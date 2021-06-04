package com.senla.dao;

import com.senla.api.dao.IRoomDao;
import com.senla.api.filter.RoomFilter;
import com.senla.comparator.room.RoomCapacityComparator;
import com.senla.comparator.room.RoomNumberComparator;
import com.senla.filter.predicate.room.RoomFilterPredicate;
import com.senla.model.Room;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class RoomDao implements IRoomDao {

    private final List<Room> repository = new ArrayList<>();
    private Long idGenerator = 1L;

    @Override
    public void save(Room entity) {
        entity.setId(idGenerator++);
        repository.add(entity);
    }

    @Override
    public Room get(Long id) {
        for (Room entity : repository) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<Room> getAll() {
        return getAll(null, null);
    }

    @Override
    public List<Room> getAll(RoomFilter filter) {
        return getAll(filter, null);
    }

    @Override
    public List<Room> getAll(String sortName) {
        return getAll(null, sortName);
    }

    @Override
    public List<Room> getAll(RoomFilter filter, String sortName) {
        List<Room> results = new ArrayList<>();

        Predicate<Room> filterPredicate = getPredicateByFilter(filter);
        if (filterPredicate != null) {
            for (Room entity : repository) {
                if (filterPredicate.test(entity)) {//проверяем с помощью метода тест подходит ли нам этот элемент
                    results.add(entity); //если подошёл - то добавляем в результирующий лист
                }
            }
        } else {
            results.addAll(repository);//если нет фильтра, то просто добавляем все элементы в другой список
        }
        Comparator<Room> comparator = getComparatorBySortName(sortName);
        if (comparator != null) {
            results.sort(comparator);//если есть компаратор, то применяем его на результирующем списке
        }
        return results;
    }

    private Comparator<Room> getComparatorBySortName(String sortName) {
        if ("number".equals(sortName)) {
            return new RoomNumberComparator();
        }
        if ("capacity".equals(sortName)) {
            return new RoomCapacityComparator();
        }
        return null;
    }

    private Predicate<Room> getPredicateByFilter(RoomFilter filter) {
        return new RoomFilterPredicate(filter);
    }
}
