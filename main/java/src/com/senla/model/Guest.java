package com.senla.model;

public class Guest extends AEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
