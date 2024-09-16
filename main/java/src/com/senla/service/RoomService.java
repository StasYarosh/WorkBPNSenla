package com.senla.service;

import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.filter.OrderFilter;
import com.senla.api.filter.RoomFilter;
import com.senla.api.service.IRoomService;
import com.senla.model.Order;
import com.senla.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RoomService implements IRoomService {

    private final IRoomDao roomDao;
    private final IOrderDao orderDao;

    public RoomService(IRoomDao roomDao, IOrderDao orderDao) {
        this.roomDao = roomDao;
        this.orderDao = orderDao;
    }

    @Override
    public Room create(Integer number, Integer capacity, Long price) {
        Room room = new Room();
        room.setPrice(price);
        room.setNumber(number);
        room.setCapacity(capacity);
        roomDao.save(room);
        return room;
    }

    @Override
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    @Override
    public List<Room> getFreeRoomsOrderByNumber() {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List<Order> currentOrders = orderDao.getAll(orderFilter);
        List<Room> notFreeRooms = currentOrders.stream().map(Order::getRoom).collect(Collectors.toList());
        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter, "number");
    }

    @Override
    public List<Room> getFreeRoomsOrderByCapacity() {
        OrderFilter orderFilter = new OrderFilter();
        orderFilter.setTargetDate(LocalDate.now());
        List<Order> currentOrders = orderDao.getAll(orderFilter);
        List<Room> notFreeRooms = currentOrders.stream().map(Order::getRoom).collect(Collectors.toList());
        RoomFilter roomFilter = new RoomFilter();
        roomFilter.setExcludedRooms(notFreeRooms);
        return roomDao.getAll(roomFilter, "capacity");
    }
}
