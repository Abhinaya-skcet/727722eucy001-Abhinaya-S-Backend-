package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.Dessert;

import java.util.List;

public interface DessertService {
    Dessert addDessert(Dessert dessert);
    List<Dessert> getAllDesserts();
}
