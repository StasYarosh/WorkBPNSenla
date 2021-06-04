package com.senla.dao;

import com.senla.api.dao.IOrderDao;
import com.senla.api.filter.OrderFilter;
import com.senla.comparator.order.OrderStartDateComparator;
import com.senla.filter.predicate.order.OrderFilterPredicate;
import com.senla.model.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class OrderDao implements IOrderDao {
    private final List<Order> repository = new ArrayList<>();
    private Long idGenerator = 1L;

    @Override
    public void save(Order entity) {
        entity.setId(idGenerator++);
        repository.add(entity);
    }

    @Override
    public Order get(Long id) {
        for (Order entity : repository) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return getAll(null, null);
    }

    @Override
    public List<Order> getAll(OrderFilter filter) {
        return getAll(filter, null);
    }

    @Override
    public List<Order> getAll(String sortName) {
        return getAll(null, sortName);
    }

    @Override
    public List<Order> getAll(OrderFilter filter, String sortName) {
        List<Order> results = new ArrayList<>();

        Predicate<Order> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            for (Order entity : repository) {
                if (filterPredicate.test(entity)) {//проверяем с помощью метода тест подходит ли нам этот элемент
                    results.add(entity); //если подошёл - то добавляем в результирующий лист
                }
            }
        } else {
            results.addAll(repository);//если нет фильтра, то просто добавляем все элементы в другой список
        }
        Comparator<Order> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            results.sort(comparator);//если есть компаратор, то применяем его на результирующем списке
        }
        return results;
    }

    private Comparator<Order> getComparatorBySortName(String sortName) {
        if ("startDate".equals(sortName)) {
            return new OrderStartDateComparator();
        }
        return null;
    }

    private Predicate<Order> getPredicateByFilter(OrderFilter filter) {
        return new OrderFilterPredicate(filter);
    }
}
