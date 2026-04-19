package com.example.bffservice.client;

import com.example.bffservice.model.OrderInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrderClient {

    private final RestTemplate restTemplate;

    @Value("${order.service.url}")
    private String orderServiceUrl;

    public OrderClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<OrderInfo> getOrdersByUser(Long userId) {
        String url = orderServiceUrl + "/api/orders/by-user/" + userId;

        try {
            return restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<OrderInfo>>() {}
            ).getBody();
        } catch (Exception e) {
            System.err.println("Ошибка при вызове Order Service: " + e.getMessage());
            return List.of();
        }
    }
}
