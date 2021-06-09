package com.senla.ui.menu;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IGuestService;
import com.senla.api.service.IOrderService;
import com.senla.api.service.IRoomService;
import com.senla.dao.GuestDao;
import com.senla.dao.OrderDao;
import com.senla.dao.RoomDao;
import com.senla.service.GuestService;
import com.senla.service.OrderService;
import com.senla.service.RoomService;
import com.senla.ui.menu.action.NotImplementedAction;
import com.senla.ui.menu.action.room.AddRoomAction;
import com.senla.ui.menu.action.ExitAction;
import com.senla.ui.menu.action.room.ShowFreeRoomsOrderByCapacityAction;
import com.senla.ui.menu.item.MenuItem;

public class Builder {

    private static IGuestDao guestDao = new GuestDao();
    private static IRoomDao roomDao = new RoomDao();
    private static IOrderDao orderDao = new OrderDao();
    private static IGuestService guestService = new GuestService(guestDao);
    private static IRoomService roomService = new RoomService(roomDao, orderDao);
    private static IOrderService orderService = new OrderService(orderDao, guestDao, roomDao);

    private Menu rootMenu;

    public void buildMenu() {
        // создаем корневое меню
        rootMenu = new Menu();
        MenuItem menuItem = new MenuItem("Показать все заказы", new NotImplementedAction(), null);
        rootMenu.setName("Главное меню");
        rootMenu.getMenuItems().add(menuItem);

        //составляем меню комнат
        Menu roomMenu = new Menu();
        roomMenu.setName("Комнаты");
        roomMenu.getMenuItems().add(new MenuItem("Добавить комнату", new AddRoomAction(roomService), null));
        roomMenu.getMenuItems().add(new MenuItem("Показать все комнаты отсортированные по вместимости", new ShowFreeRoomsOrderByCapacityAction(roomService), null));
        //добавляем пункт для возврата в главное меню
        roomMenu.getMenuItems().add(new MenuItem("В главное меню", null, rootMenu));

        //добавляем пункт меню для перехода в меню комнат
        rootMenu.getMenuItems().add(new MenuItem("К комнатам", null, roomMenu));
        rootMenu.getMenuItems().add(new MenuItem("Выход", new ExitAction(), null));

    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
