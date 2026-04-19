package com.example.orderservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Double amount;
    private String currency;
    private List<OrderItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderItem {

        private String productName;
        private Integer quantity;
        private Double price;
    }
}
