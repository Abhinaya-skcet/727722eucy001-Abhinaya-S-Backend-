package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.entity.Dessert;
import com.example.RestaurantBackend.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desserts")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the URL if necessary
public class DessertController {

    @Autowired
    private DessertService dessertService;

    @PostMapping
    public ResponseEntity<Dessert> addDessert(@RequestBody Dessert dessert) {
        Dessert createdDessert = dessertService.addDessert(dessert);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDessert);
    }

    @GetMapping
    public ResponseEntity<List<Dessert>> getAllDesserts() {
        List<Dessert> desserts = dessertService.getAllDesserts();
        return ResponseEntity.ok(desserts);
    }
}
