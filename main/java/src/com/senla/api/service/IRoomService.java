package com.senla.api.service;

import com.senla.model.Room;

import java.util.List;

public interface IRoomService {

    Room create(Integer number, Integer capacity, Long price);

    List<Room> getAll();

    List<Room> getFreeRoomsOrderByNumber();

    List<Room> getFreeRoomsOrderByCapacity();
}
