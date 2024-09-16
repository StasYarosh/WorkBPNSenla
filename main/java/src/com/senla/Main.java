package com.senla;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IGuestService;
import com.senla.api.service.IOrderService;
import com.senla.api.service.IRoomService;
import com.senla.dao.GuestDao;
import com.senla.dao.OrderDao;
import com.senla.dao.RoomDao;
import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.service.GuestService;
import com.senla.service.OrderService;
import com.senla.service.RoomService;
import com.senla.ui.menu.Builder;
import com.senla.ui.menu.MenuController;
import com.senla.ui.menu.Navigator;

import java.time.LocalDate;
import java.util.List;

public class Main {
    private static IGuestDao guestDao = new GuestDao();
    private static IRoomDao roomDao = new RoomDao();
    private static IOrderDao orderDao = new OrderDao();
    private static IGuestService guestService = new GuestService(guestDao);
    private static IRoomService roomService = new RoomService(roomDao, orderDao);
    private static IOrderService orderService = new OrderService(orderDao, guestDao, roomDao);

    public static void main(String[] args) {
        Builder builder = new Builder();
        Navigator navigator = new Navigator();
        MenuController menuController = new MenuController(builder, navigator);
        menuController.run();
    }
}
