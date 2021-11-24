package com.example.OnlineCommerceAPI.controller;

import com.example.OnlineCommerceAPI.exceptions.OrderNotFoundException;
import com.example.OnlineCommerceAPI.exceptions.ProductNotFoundException;
import com.example.OnlineCommerceAPI.model.Product;
import com.example.OnlineCommerceAPI.repository.OrderRepository;
import com.example.OnlineCommerceAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/products")
    List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{productId}")
    Product getProductById(@PathVariable Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @PostMapping("/products")
    Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PostMapping("/orders/{orderId}/products")
    Product addProductToOrder(@RequestBody Product product, @PathVariable Long orderId) {
        if (orderRepository.findById(orderId).isEmpty()) {
            throw new OrderNotFoundException(orderId);
        }

        orderRepository.getById(orderId).getProducts().add(product);
        return productRepository.save(product);
    }

    @PutMapping("/products/{productId}")
    Product updateProduct(@RequestBody Product newProduct,
                          @PathVariable Long productId) {
        return productRepository.findById(productId)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(productId);
                    return productRepository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return productRepository.findById(productId)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ProductNotFoundException(productId));
    }
}
