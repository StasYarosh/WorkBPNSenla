package com.senla.ui.menu;

import com.senla.ui.menu.item.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> menuItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        if (menuItems == null) {
            menuItems = new ArrayList<>();
        }
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
