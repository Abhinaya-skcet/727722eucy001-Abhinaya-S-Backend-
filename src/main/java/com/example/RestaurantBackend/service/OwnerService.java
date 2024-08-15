package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {
    OwnerDTO createOwner(OwnerDTO ownerDTO);
    OwnerDTO getOwnerById(Long ownerId);
    List<OwnerDTO> getAllOwners();
    OwnerDTO updateOwner(Long ownerId, OwnerDTO ownerDTO);
    void deleteOwner(Long ownerId);
}
