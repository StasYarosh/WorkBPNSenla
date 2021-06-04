package com.senla.model;

import java.time.LocalDate;

public class Order extends AEntity {
    private Room room;
    private Guest guest;
    private LocalDate startDate;
    private LocalDate endDate;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", room=" + room +
                ", guest=" + guest +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
