package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.entity.Dessert;
import com.example.RestaurantBackend.repository.DessertRepository;
import com.example.RestaurantBackend.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DessertServiceImpl implements DessertService {

    @Autowired
    private DessertRepository dessertRepository;

    @Override
    public Dessert addDessert(Dessert dessert) {
        return dessertRepository.save(dessert);
    }

    @Override
    public List<Dessert> getAllDesserts() {
        return dessertRepository.findAll();
    }
}
