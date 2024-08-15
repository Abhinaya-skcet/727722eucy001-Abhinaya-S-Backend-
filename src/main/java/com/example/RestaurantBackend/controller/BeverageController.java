package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.entity.Beverage;
import com.example.RestaurantBackend.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beverages")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the URL if necessary
public class BeverageController {

    @Autowired
    private BeverageService beverageService;

    @PostMapping
    public ResponseEntity<Beverage> addBeverage(@RequestBody Beverage beverage) {
        Beverage createdBeverage = beverageService.addBeverage(beverage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBeverage);
    }

    @GetMapping
    public ResponseEntity<List<Beverage>> getAllBeverages() {
        List<Beverage> beverages = beverageService.getAllBeverages();
        return ResponseEntity.ok(beverages);
    }
}
