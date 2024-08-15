package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.Starter;

import java.util.List;

public interface StarterService {
    Starter addStarter(Starter starter);
    List<Starter> getAllStarters();
}
