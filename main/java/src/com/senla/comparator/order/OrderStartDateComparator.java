package com.senla.comparator.order;

import com.senla.model.Order;

import java.util.Comparator;

public class OrderStartDateComparator implements Comparator<Order> {
    @Override
    public int compare(Order first, Order second) {
        return first.getStartDate().compareTo(second.getEndDate());
    }
}
