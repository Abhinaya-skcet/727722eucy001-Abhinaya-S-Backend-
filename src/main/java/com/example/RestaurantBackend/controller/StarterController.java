package com.example.RestaurantBackend.controller;


import com.example.RestaurantBackend.entity.Starter;
import com.example.RestaurantBackend.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/starters")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the URL if necessary
public class StarterController {

    @Autowired
    private StarterService starterService;

    @PostMapping
    public ResponseEntity<Starter> addStarter(@RequestBody Starter starter) {
        Starter createdStarter = starterService.addStarter(starter);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStarter);
    }

    @GetMapping
    public ResponseEntity<List<Starter>> getAllStarters() {
        List<Starter> starters = starterService.getAllStarters();
        return ResponseEntity.ok(starters);
    }
}
