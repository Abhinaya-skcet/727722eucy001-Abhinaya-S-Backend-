package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.entity.Starter;
import com.example.RestaurantBackend.repository.StarterRepository;
import com.example.RestaurantBackend.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarterServiceImpl implements StarterService {

    @Autowired
    private StarterRepository starterRepository;

    @Override
    public Starter addStarter(Starter starter) {
        return starterRepository.save(starter);
    }

    @Override
    public List<Starter> getAllStarters() {
        return starterRepository.findAll();
    }
}
