package com.example.RestaurantBackend.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {
    private Long id;
    private String userEmail;
    private String address;
    private String description;
    private BigDecimal totalPrice;
    private String status;
    private List<OrderDTO> items;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderDTO> getItems() {
		return items;
	}
	public void setItems(List<OrderDTO> items) {
		this.items = items;
	}

    
    // getters and setters
}
