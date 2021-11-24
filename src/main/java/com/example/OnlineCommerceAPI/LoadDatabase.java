package com.example.OnlineCommerceAPI;

import com.example.OnlineCommerceAPI.model.Order;
import com.example.OnlineCommerceAPI.model.Product;
import com.example.OnlineCommerceAPI.model.User;
import com.example.OnlineCommerceAPI.repository.OrderRepository;
import com.example.OnlineCommerceAPI.repository.ProductRepository;
import com.example.OnlineCommerceAPI.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   OrderRepository orderRepository,
                                   ProductRepository productRepository) {

        return args -> {
            User user1 = new User("User1");
            User user2 = new User("User2");

            log.info("Inserting into db " + userRepository.save(user1));
            log.info("Inserting into db " + userRepository.save(user2));

            Order order1 = new Order();
            order1.setUser(user1);
            Order order2 = new Order();
            order2.setUser(user1);
            Order order3 = new Order();
            order3.setUser(user2);
            Order order4= new Order();
            order4.setUser(user2);

            Product product1 = new Product("product1", 10.5);
            Product product2 = new Product("product2", 23.99);
            Product product3 = new Product("product3", 99.99);

            log.info("Inserting into db " + productRepository.save(product1));
            log.info("Inserting into db " + productRepository.save(product2));
            log.info("Inserting into db " + productRepository.save(product3));

            order1.getProducts().add(product1);
            order2.getProducts().add(product1);
            order2.getProducts().add(product2);
            order3.getProducts().add(product1);
            order3.getProducts().add(product2);
            order3.getProducts().add(product3);
            order4.getProducts().add(product1);
            order4.getProducts().add(product3);

            log.info("Inserting into db " + orderRepository.save(order1));
            log.info("Inserting into db " + orderRepository.save(order2));
            log.info("Inserting into db " + orderRepository.save(order3));
            log.info("Inserting into db " + orderRepository.save(order4));
        };
    }
}
