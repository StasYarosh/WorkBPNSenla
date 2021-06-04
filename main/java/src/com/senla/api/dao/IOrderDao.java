package com.senla.api.dao;


import com.senla.api.filter.OrderFilter;
import com.senla.model.Order;

import java.util.List;

public interface IOrderDao {

    void save(Order entity);

    Order get(Long id);

    List<Order> getAll();

    List<Order> getAll(OrderFilter filter);

    List<Order> getAll(String sortName);

    List<Order> getAll(OrderFilter filter, String sortName);
}
