package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.Beverage;

import java.util.List;

public interface BeverageService {
    Beverage addBeverage(Beverage beverage);
    List<Beverage> getAllBeverages();
}
