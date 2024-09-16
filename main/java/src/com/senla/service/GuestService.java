package com.senla.service;

import com.senla.api.dao.IGuestDao;
import com.senla.api.service.IGuestService;
import com.senla.model.Guest;

public class GuestService implements IGuestService {

    private final IGuestDao guestDao;

    public GuestService(IGuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Override
    public Guest create(String name) {
        Guest guest = new Guest();
        guest.setName(name);
        guestDao.save(guest);
        return guest;
    }
}
