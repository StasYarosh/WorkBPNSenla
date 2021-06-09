package com.senla.ui.menu;

import com.senla.ui.menu.item.MenuItem;

import java.util.List;

public class Navigator {

    private Menu currentMenu;

    public void printMenu() {
        System.out.println(currentMenu.getName());
        List<MenuItem> menuItems = currentMenu.getMenuItems();
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get(i).getTitle());
        }
    }

    public void navigate(Integer index) {
        --index;

        int itemsCount = currentMenu.getMenuItems().size();
        if (index < 0 || itemsCount <= index) {
            System.out.println("Такого пункта меню не существует");
            return;
        }

        MenuItem selectedMenuItem = currentMenu.getMenuItems().get(index);
        selectedMenuItem.doAction();

        if (selectedMenuItem.getNextMenu() != null) {
            this.setCurrentMenu(selectedMenuItem.getNextMenu());
        }
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
