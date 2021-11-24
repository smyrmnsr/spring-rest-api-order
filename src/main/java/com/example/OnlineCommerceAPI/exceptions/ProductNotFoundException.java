package com.example.OnlineCommerceAPI.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long productId) {
        super("Could not find product: " + productId);
    }
}
