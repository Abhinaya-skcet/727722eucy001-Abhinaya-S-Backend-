package com.example.RestaurantBackend.service;

import java.math.BigDecimal;

public interface PaymentService {
    boolean processPayment(BigDecimal amount);
}
