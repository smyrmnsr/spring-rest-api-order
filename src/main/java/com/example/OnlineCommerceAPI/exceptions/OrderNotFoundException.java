package com.example.OnlineCommerceAPI.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super("Could not find order " + orderId);
    }
}
