package com.example.bffservice.client;


import com.example.bffservice.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto getUserById(Long userId) {
        String url = userServiceUrl + "/api/users/" + userId;

        try {
            return restTemplate.getForObject(url, UserDto.class);
        } catch (Exception e) {
            System.err.println("Ошибка при вызове User Service: " + e.getMessage());
            return null;
        }
    }
}