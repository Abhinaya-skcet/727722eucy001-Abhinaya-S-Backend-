package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.entity.CartItem;
import com.example.RestaurantBackend.repository.CartItemRepository;
import com.example.RestaurantBackend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public void deleteCartItem(Long itemId) {
        if (cartItemRepository.existsById(itemId)) {
            cartItemRepository.deleteById(itemId);
        }
    }
}
