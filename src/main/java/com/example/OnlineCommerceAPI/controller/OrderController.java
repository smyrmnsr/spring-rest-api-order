package com.example.OnlineCommerceAPI.controller;

import com.example.OnlineCommerceAPI.exceptions.OrderNotFoundException;
import com.example.OnlineCommerceAPI.exceptions.UserNotFoundException;
import com.example.OnlineCommerceAPI.model.Order;
import com.example.OnlineCommerceAPI.repository.OrderRepository;
import com.example.OnlineCommerceAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/orders")
    List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{orderId}")
    Order getOrderById(@PathVariable Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @GetMapping("/users/{userId}/orders")
    List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @GetMapping("/orders/{orderId}/cost")
    Double getOrderCost(@PathVariable Long orderId) {
        if (orderRepository.findById(orderId).isEmpty()) {
            throw new OrderNotFoundException(orderId);
        }

        return orderRepository.getById(orderId).getTotalCost();
    }

    @PostMapping("users/{userId}/orders")
    Order addOrder(@PathVariable Long userId,
                   @RequestBody Order order) {
        if (userRepository.findById(userId).isEmpty()) {
           throw new UserNotFoundException(userId);
        }
        order.setUser(userRepository.getById(userId));
        return orderRepository.save(order);
    }

    @PutMapping("orders/{orderId}")
    Order updateOrder(@PathVariable Long orderId,
                      @RequestBody Order newOrder) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    order.setUser(newOrder.getUser());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setOrderId(orderId);
                    return orderRepository.save(newOrder);
                });
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    orderRepository.delete(order);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new OrderNotFoundException(orderId));
    }
}
