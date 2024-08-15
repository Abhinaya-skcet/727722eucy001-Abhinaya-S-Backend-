package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.entity.Beverage;
import com.example.RestaurantBackend.repository.BeverageRepository;
import com.example.RestaurantBackend.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeverageServiceImpl implements BeverageService {

    @Autowired
    private BeverageRepository beverageRepository;

    @Override
    public Beverage addBeverage(Beverage beverage) {
        return beverageRepository.save(beverage);
    }

    @Override
    public List<Beverage> getAllBeverages() {
        return beverageRepository.findAll();
    }
}
