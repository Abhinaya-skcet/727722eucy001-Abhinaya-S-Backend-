package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.entity.CartItem;
import com.example.RestaurantBackend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the URL if necessary
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) {
        CartItem createdCartItem = cartItemService.addCartItem(cartItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCartItem);
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long itemId) {
        cartItemService.deleteCartItem(itemId);
        return ResponseEntity.noContent().build();
    }
}
