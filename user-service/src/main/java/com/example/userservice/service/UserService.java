package com.example.userservice.service;

import com.example.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final Map<Long, User> userDatabase = new HashMap<>();

    public UserService() {
        userDatabase.put(1L, new User(
                1L,
                "Иванов",
                "Иван",
                "Иванович",
                "г. Москва, ул. Ленина, д. 10",
                "+7-900-123-45-67",
                "ivan@example.com"
        ));

        userDatabase.put(2L, new User(
                2L,
                "Петров",
                "Пётр",
                "Петрович",
                "г. Санкт-Петербург, ул. Невский, д. 25",
                "+7-900-987-65-43",
                "petr@example.com"
        ));
    }

    public Optional<User> findById(Long id) {
        // Optional.ofNullable() создаёт Optional, который может быть пустым
        return Optional.ofNullable(userDatabase.get(id));
    }
}
