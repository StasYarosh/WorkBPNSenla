package com.senla.ui.menu;

import java.util.Scanner;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        builder.buildMenu();
        Menu menu = builder.getRootMenu();
        navigator.setCurrentMenu(menu);
        while (true) {
            navigator.printMenu();
            try {
                String next = scanner.next();
                int index = Integer.parseInt(next);
                navigator.navigate(index);
            } catch (NumberFormatException exception) {
                System.err.println("Некорректный ввод, ожидается число");
            }
        }
    }
}
