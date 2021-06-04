package com.senla.filter.predicate.order;

import com.senla.api.filter.OrderFilter;
import com.senla.model.Order;

import java.util.function.Predicate;

public class OrderFilterPredicate implements Predicate<Order> {

    private final OrderFilter orderFilter;

    public OrderFilterPredicate(OrderFilter orderFilter) {
        this.orderFilter = orderFilter;
    }

    @Override
    public boolean test(Order order) {
        if (orderFilter == null) {//если нет фильтра, то ничего не проверяем, считаем что элемент нам подходит - true
            return true;
        }
        if (orderFilter.getTargetDate() != null) {
            if (orderFilter.getTargetDate().compareTo(order.getStartDate()) < 0 ||
                    orderFilter.getTargetDate().compareTo(order.getEndDate()) > 0) {
                return false;
            }
        }
        //если не один критерий не вернул false, то значит элемент нам подходит по всем критериям и возвращаем true
        return true;
    }
}
