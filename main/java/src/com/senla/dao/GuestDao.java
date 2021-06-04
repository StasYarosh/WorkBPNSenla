package com.senla.dao;

import com.senla.api.dao.IGuestDao;
import com.senla.api.filter.GuestFilter;
import com.senla.model.Guest;

import java.util.Comparator;
import java.util.function.Predicate;

public class GuestDao extends AbstractDao<Guest, GuestFilter> implements IGuestDao {
    @Override
    protected Comparator<Guest> getComparatorBySortName(String sortName) {
        //пока что у гостя нет возможных сортировок, возвращаем null
        return null;
    }

    @Override
    protected Predicate<Guest> getPredicateByFilter(GuestFilter filter) {
        //пока что у гостя нет ни 1 критерия для фильтрации, возвращаем null
        return null;
    }
}
