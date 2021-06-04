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
        Guest guestMike = guestService.create("Mike");
        Guest guestAlis = guestService.create("Alis");
        Guest guestRobert = guestService.create("Robert");

        Room room3 = roomService.create(3, 2, 310L);
        Room room1 = roomService.create(1, 2, 300L);
        Room room4 = roomService.create(4, 4, 290L);
        Room room2 = roomService.create(2, 3, 500L);


        System.out.println("____________________________________");
        System.out.println("все комнаты");
        List<Room> allRooms = roomService.getAll();
        allRooms.forEach(System.out::println);
        System.out.println("____________________________________");
        System.out.println("свободные (отсортированные по номеру) комнаты перед заказами");
        List<Room> freeRoomsOrderByNumber = roomService.getFreeRoomsOrderByNumber();
        freeRoomsOrderByNumber.forEach(System.out::println);
        System.out.println("____________________________________");

        System.out.println("свободные (отсортированные по вместимости) комнаты перед заказами");
        List<Room> freeRoomsOrderByCapacity = roomService.getFreeRoomsOrderByCapacity();
        freeRoomsOrderByCapacity.forEach(System.out::println);
        System.out.println("____________________________________");

        Order order = orderService.create(4L /*id = 4 - room2*/, 2L /*id = 2 - guestAlis*/, LocalDate.now().minusDays(1), LocalDate.now().plusDays(3));

        System.out.println("свободные (отсортированные по номеру) комнаты после 1 заказа");
        freeRoomsOrderByNumber = roomService.getFreeRoomsOrderByNumber();
        freeRoomsOrderByNumber.forEach(System.out::println);
        System.out.println("____________________________________");

        Order order2 = orderService.create(3L /*id = 4 - room4*/, 1L /*id = 2 - guestMike*/, LocalDate.now().minusDays(1), LocalDate.now().plusDays(3));

        System.out.println("свободные (отсортированные по номеру) комнаты после 2 заказов");
        freeRoomsOrderByNumber = roomService.getFreeRoomsOrderByNumber();
        freeRoomsOrderByNumber.forEach(System.out::println);
        System.out.println("____________________________________");

        //заказ который ещё не вступает в силу, начинается с завтра
        Order order3 = orderService.create(1L /*id = 4 - room3*/, 1L /*id = 2 - guestMike*/, LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));

        System.out.println("свободные (отсортированные по номеру) комнаты после 3 заказов, один из которых для комнаты с номером 3 ещё не начался");
        freeRoomsOrderByNumber = roomService.getFreeRoomsOrderByNumber();
        freeRoomsOrderByNumber.forEach(System.out::println);
        System.out.println("____________________________________");
    }
}
