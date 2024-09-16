package com.senla.dao;

import com.senla.api.dao.IOrderDao;
import com.senla.api.filter.OrderFilter;
import com.senla.model.Order;

import java.util.Comparator;
import java.util.function.Predicate;

public class OrderDao extends AbstractDao<Order, OrderFilter> implements IOrderDao {
    @Override
    protected Comparator<Order> getComparatorBySortName(String sortName) {
        if ("startDate".equals(sortName)) {
            return Comparator.comparing(Order::getStartDate);
        }
        return null;
    }

    @Override
    protected Predicate<Order> getPredicateByFilter(OrderFilter filter) {
        if (filter == null) {
            return null;
        }
        return (order) -> {
            if (filter.getTargetDate() != null) {
                if (filter.getTargetDate().compareTo(order.getStartDate()) < 0 ||
                        filter.getTargetDate().compareTo(order.getEndDate()) > 0) {
                    return false;
                }
            }
            return true;
        };
    }
}
