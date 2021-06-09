package com.senla.ui.menu.action.room;

import com.senla.api.service.IRoomService;
import com.senla.ui.menu.action.IAction;

import java.util.Scanner;

public class AddRoomAction implements IAction {

    private final IRoomService roomService;

    public AddRoomAction(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);//его нужно вынести в утилиту какую-нибудь, чтобы пользоваться 1 экземпляром сканнера в приложении

        System.out.print("Введите номер комнаты: ");
        Integer number = Integer.parseInt(scanner.next());
        System.out.print("Введите вместимость комнаты: ");
        Integer capacity = Integer.parseInt(scanner.next());
        System.out.print("Введите стоимость комнаты: ");
        Long price = Long.parseLong(scanner.next());
        roomService.create(number, capacity, price);
    }
}
