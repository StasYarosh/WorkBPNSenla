package com.senla.api.service;

import com.senla.model.Order;

import java.time.LocalDate;

public interface IOrderService {

    Order create(Long roomId, Long guestId, LocalDate startDate, LocalDate endDate);
}
