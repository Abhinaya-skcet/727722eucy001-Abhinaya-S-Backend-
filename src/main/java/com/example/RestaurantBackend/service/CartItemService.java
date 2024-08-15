package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem addCartItem(CartItem cartItem);
    List<CartItem> getAllCartItems();
    void deleteCartItem(Long itemId);  // Add this method
}
