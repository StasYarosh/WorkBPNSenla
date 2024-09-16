package com.senla.api.dao;

import com.senla.model.AEntity;

import java.util.List;

public interface IGenericDao<T extends AEntity, F> {

    void save(T entity);

    T get(Long id);

    //остальные crud методы

    List<T> getAll();
    List<T> getAll(F filter);
    List<T> getAll(String sortName);
    List<T> getAll(F filter, String sortName);
}
