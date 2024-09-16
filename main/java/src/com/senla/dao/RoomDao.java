package com.senla.dao;

import com.senla.api.dao.IRoomDao;
import com.senla.api.filter.RoomFilter;
import com.senla.model.Room;

import java.util.Comparator;
import java.util.function.Predicate;

public class RoomDao extends AbstractDao<Room, RoomFilter> implements IRoomDao {
    @Override
    protected Comparator<Room> getComparatorBySortName(String sortName) {
        if ("number".equals(sortName)) {
            return Comparator.comparing(Room::getNumber);
        }
        if ("capacity".equals(sortName)) {
            return Comparator.comparing(Room::getCapacity);
        }
        return null;
    }

    @Override
    protected Predicate<Room> getPredicateByFilter(RoomFilter filter) {
        if (filter == null) {
            return null;
        }
        return (room) -> {
            if (filter.getExcludedRooms() != null) {
                //исключаем комнату, если она присутствует в списке на исключение
                if (filter.getExcludedRooms().contains(room)) {
                    return false;
                }
            }
            if (filter.getMinCapacity() != null) {
                //исключаем комнату, если ее вместимость меньше чем задано в фильтре
                if (filter.getMinCapacity() > room.getCapacity()) {
                    return false;
                }
            }
            return true;
        };
    }
}
