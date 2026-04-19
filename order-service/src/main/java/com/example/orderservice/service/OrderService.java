package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final List<Order> orderDatabase = new ArrayList<>();

    public OrderService() {
        orderDatabase.add(new Order(
                100L,
                1L,
                5000.00,
                "RUB",
                Arrays.asList(
                        new Order.OrderItem("Ноутбук", 1, 4500.00),
                        new Order.OrderItem("Мышка", 2, 250.00)
                )
        ));

        orderDatabase.add(new Order(
                101L,
                1L,
                1500.00,
                "RUB",
                Arrays.asList(
                        new Order.OrderItem("Клавиатура", 1, 1500.00)
                )
        ));

        orderDatabase.add(new Order(
                102L,
                2L,
                3000.00,
                "USD",
                Arrays.asList(
                        new Order.OrderItem("Монитор", 1, 3000.00)
                )
        ));
    }

    public List<Order> findByUserId(Long userId) {

        return orderDatabase.stream()
                .filter(order -> order.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}