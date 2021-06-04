package com.senla.dao;

import com.senla.api.dao.IGuestDao;
import com.senla.api.filter.GuestFilter;
import com.senla.model.Guest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class GuestDao implements IGuestDao {
    private final List<Guest> repository = new ArrayList<>();
    private Long idGenerator = 1L;

    @Override
    public void save(Guest entity) {
        entity.setId(idGenerator++);
        repository.add(entity);
    }

    @Override
    public Guest get(Long id) {
        for (Guest entity : repository) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<Guest> getAll() {
        return getAll(null, null);
    }

    @Override
    public List<Guest> getAll(GuestFilter filter) {
        return getAll(filter, null);
    }

    @Override
    public List<Guest> getAll(String sortName) {
        return getAll(null, sortName);
    }

    @Override
    public List<Guest> getAll(GuestFilter filter, String sortName) {
        List<Guest> results = new ArrayList<>();

        Predicate<Guest> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            for (Guest entity : repository) {
                if (filterPredicate.test(entity)) {//проверяем с помощью метода тест подходит ли нам этот элемент
                    results.add(entity); //если подошёл - то добавляем в результирующий лист
                }
            }
        } else {
            results.addAll(repository);//если нет фильтра, то просто добавляем все элементы в другой список
        }
        Comparator<Guest> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            results.sort(comparator);//если есть компаратор, то применяем его на результирующем списке
        }
        return results;
    }

    private Comparator<Guest> getComparatorBySortName(String sortName) {
        //пока что у гостя нет возможных сортировок, возвращаем null
        return null;
    }

    private Predicate<Guest> getPredicateByFilter(GuestFilter filter) {
        //пока что у гостя нет ни 1 критерия для фильтрации, возвращаем null
        return null;
    }
}
