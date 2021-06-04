package com.senla.comparator.room;

import com.senla.model.Room;

import java.util.Comparator;

public class RoomCapacityComparator implements Comparator<Room> {
    @Override
    public int compare(Room first, Room second) {
        return first.getCapacity().compareTo(second.getCapacity());
    }
}
