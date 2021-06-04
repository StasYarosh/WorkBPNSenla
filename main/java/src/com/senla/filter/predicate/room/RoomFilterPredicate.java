package com.senla.filter.predicate.room;

import com.senla.api.filter.RoomFilter;
import com.senla.model.Room;

import java.util.function.Predicate;

public class RoomFilterPredicate implements Predicate<Room> {

    private final RoomFilter roomFilter;

    public RoomFilterPredicate(RoomFilter roomFilter) {
        this.roomFilter = roomFilter;
    }

    @Override
    public boolean test(Room room) {
        if (roomFilter == null) {
            return true;//если нет фильтра, то ничего не проверяем, считаем что элемент нам подходит - true
        }
        //проверяем все критерии
        if (roomFilter.getExcludedRooms() != null) {
            //исключаем комнату, если она присутствует в списке на исключение
            if (roomFilter.getExcludedRooms().contains(room)) {
                return false;
            }
        }
        if (roomFilter.getMinCapacity() != null) {
            //исключаем комнату, если ее вместимость меньше чем задано в фильтре
            if (roomFilter.getMinCapacity() > room.getCapacity()) {
                return false;
            }
        }
        //если не один критерий не вернул false, то значит элемент нам подходит по всем критериям и возвращаем true
        return true;
    }
}
