package com.senla.service;

import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.api.service.IOrderService;
import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;

import java.time.LocalDate;

public class OrderService implements IOrderService {

    private final IOrderDao orderDao;
    private final IGuestDao guestDao;
    private final IRoomDao roomDao;

    public OrderService(IOrderDao orderDao, IGuestDao guestDao, IRoomDao roomDao) {
        this.orderDao = orderDao;
        this.guestDao = guestDao;
        this.roomDao = roomDao;
    }

    @Override
    public Order create(Long roomId, Long guestId, LocalDate startDate, LocalDate endDate) {
        Order order = new Order();
        Room room = roomDao.get(roomId);
        Guest guest = guestDao.get(guestId);
        order.setRoom(room);
        order.setGuest(guest);
        order.setStartDate(startDate);
        order.setEndDate(endDate);
        orderDao.save(order);
        return order;
    }
}
