package com.example.OnlineCommerceAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinColumn(name = "order_id")
    List<Product> products = new ArrayList<>();

    @Transient
    public Double getTotalCost() {
        double sum = 0;

        for (Product product : products) {
            sum += product.getPrice();
        }

        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.products.size();
    }
}
