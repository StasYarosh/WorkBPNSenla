package com.senla.ui.menu.action.room;

import com.senla.api.service.IRoomService;
import com.senla.model.Room;
import com.senla.ui.menu.action.IAction;

import java.util.List;

public class ShowFreeRoomsOrderByCapacityAction implements IAction {

    private final IRoomService roomService;

    public ShowFreeRoomsOrderByCapacityAction(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public void execute() {
        List<Room> freeRoomsOrderByCapacity = roomService.getFreeRoomsOrderByCapacity();
        freeRoomsOrderByCapacity.forEach(System.out::println);
    }
}
