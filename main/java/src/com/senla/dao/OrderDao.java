package com.senla.dao;

import com.senla.api.dao.IOrderDao;
import com.senla.api.filter.OrderFilter;
import com.senla.comparator.order.OrderStartDateComparator;
import com.senla.filter.predicate.order.OrderFilterPredicate;
import com.senla.model.Order;

import java.util.Comparator;
import java.util.function.Predicate;

public class OrderDao extends AbstractDao<Order, OrderFilter> implements IOrderDao {
    @Override
    protected Comparator<Order> getComparatorBySortName(String sortName) {
        if ("startDate".equals(sortName)) {
            return new OrderStartDateComparator();
        }
        return null;
    }

    @Override
    protected Predicate<Order> getPredicateByFilter(OrderFilter filter) {
        return new OrderFilterPredicate(filter);
    }
}
