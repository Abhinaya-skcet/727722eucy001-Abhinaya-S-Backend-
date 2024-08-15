package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.dto.OwnerDTO;
import com.example.RestaurantBackend.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@CrossOrigin
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO) {
        return ResponseEntity.ok(ownerService.createOwner(ownerDTO));
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long ownerId) {
        return ResponseEntity.ok(ownerService.getOwnerById(ownerId));
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> getAllOwners() {
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long id, @RequestBody OwnerDTO ownerDTO) {
        return ResponseEntity.ok(ownerService.updateOwner(id, ownerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }
}
