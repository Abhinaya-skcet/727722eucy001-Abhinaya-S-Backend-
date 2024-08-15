package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.dto.OwnerDTO;
import com.example.RestaurantBackend.entity.Owner;
import com.example.RestaurantBackend.repository.OwnerRepository;
import com.example.RestaurantBackend.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        try {
            Owner owner = modelMapper.map(ownerDTO, Owner.class);
            owner = ownerRepository.save(owner);
            return modelMapper.map(owner, OwnerDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Owner creation failed", e);
        }
    }

    @Override
    public OwnerDTO getOwnerById(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        return modelMapper.map(owner, OwnerDTO.class);
    }

    @Override
    public List<OwnerDTO> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(owner -> modelMapper.map(owner, OwnerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDTO updateOwner(Long ownerId, OwnerDTO ownerDTO) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        modelMapper.map(ownerDTO, owner);
        owner = ownerRepository.save(owner);
        return modelMapper.map(owner, OwnerDTO.class);
    }

    @Override
    public void deleteOwner(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}
