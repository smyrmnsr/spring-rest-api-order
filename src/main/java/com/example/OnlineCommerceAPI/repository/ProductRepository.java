package com.example.OnlineCommerceAPI.repository;

import com.example.OnlineCommerceAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
