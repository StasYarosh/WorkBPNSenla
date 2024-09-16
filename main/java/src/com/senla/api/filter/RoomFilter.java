package com.senla.api.filter;

import com.senla.model.Room;

import java.util.List;

public class RoomFilter {
    /**
     * Комнаты, которые нужно исключить из выборки
     */
    private List<Room> excludedRooms;
    /**
     * Минимальное значение вместимости для выбираемых комнат
     */
    private Integer minCapacity;

    public List<Room> getExcludedRooms() {
        return excludedRooms;
    }

    public void setExcludedRooms(List<Room> excludedRooms) {
        this.excludedRooms = excludedRooms;
    }

    public Integer getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(Integer minCapacity) {
        this.minCapacity = minCapacity;
    }
}
