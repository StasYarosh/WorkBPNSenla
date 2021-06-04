package com.senla.dao;

import com.senla.api.dao.IRoomDao;
import com.senla.api.filter.RoomFilter;
import com.senla.comparator.room.RoomCapacityComparator;
import com.senla.comparator.room.RoomNumberComparator;
import com.senla.filter.predicate.room.RoomFilterPredicate;
import com.senla.model.Room;

import java.util.Comparator;
import java.util.function.Predicate;

public class RoomDao extends AbstractDao<Room, RoomFilter> implements IRoomDao {
    @Override
    protected Comparator<Room> getComparatorBySortName(String sortName) {
        if ("number".equals(sortName)) {
            return new RoomNumberComparator();
        }
        if ("capacity".equals(sortName)) {
            return new RoomCapacityComparator();
        }
        return null;
    }

    @Override
    protected Predicate<Room> getPredicateByFilter(RoomFilter filter) {
        return new RoomFilterPredicate(filter);
    }
}
