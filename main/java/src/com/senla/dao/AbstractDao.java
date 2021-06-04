package com.senla.dao;

import com.senla.api.dao.IGenericDao;
import com.senla.model.AEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDao<T extends AEntity, F> implements IGenericDao<T, F> {

    private final List<T> repository = new ArrayList<>();
    private Long idGenerator = 1L;

    @Override
    public void save(T entity) {
        entity.setId(idGenerator++);
        repository.add(entity);
    }

    @Override
    public T get(Long id) {
        for (T entity : repository) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return getAll(null, null);
    }

    @Override
    public List<T> getAll(F filter) {
        return getAll(filter, null);
    }

    @Override
    public List<T> getAll(String sortName) {
        return getAll(null, sortName);
    }

    @Override
    public List<T> getAll(F filter, String sortName) {
        List<T> results = new ArrayList<>();

        Predicate<T> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            for (T entity : repository) {
                if (filterPredicate.test(entity)) {//проверяем с помощью метода тест подходит ли нам этот элемент
                    results.add(entity); //если подошёл - то добавляем в результирующий лист
                }
            }
        } else {
            results.addAll(repository);//если нет фильтра, то просто добавляем все элементы в другой список
        }
        Comparator<T> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            results.sort(comparator);//если есть компаратор, то применяем его на результирующем списке
        }
        return results;
    }

    protected abstract Comparator<T> getComparatorBySortName(String sortName);

    protected abstract Predicate<T> getPredicateByFilter(F filter);
}
