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
        return repository.stream().filter(entity -> entity.getId().equals(id)).findFirst().orElse(null);
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
        Stream<T> stream = repository.stream();
        Predicate<T> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            stream = stream.filter(filterPredicate);
        }
        Comparator<T> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            stream = stream.sorted(comparator);
        }
        return stream.collect(Collectors.toList());
    }

    protected abstract Comparator<T> getComparatorBySortName(String sortName);

    protected abstract Predicate<T> getPredicateByFilter(F filter);
}
