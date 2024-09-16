package com.senla.model;

public class Room extends AEntity {

    private Integer number;
    private Integer capacity;
    private Long price;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + getId() +
                ", number=" + number +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
