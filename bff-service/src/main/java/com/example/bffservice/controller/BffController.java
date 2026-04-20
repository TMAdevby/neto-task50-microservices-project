package com.example.bffservice.controller;

import com.example.bffservice.client.OrderClient;
import com.example.bffservice.client.UserClient;
import com.example.bffservice.dto.UserDto;
import com.example.bffservice.model.OrderInfo;
import com.example.bffservice.model.UserFullInfo;
import com.example.bffservice.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private OrderClient orderClient;

    @GetMapping("/user/{userId}")
    public UserFullInfo getUserFullInfo(@PathVariable("userId") Long userId) {

        UserDto user = userClient.getUserById(userId);
        if (user == null) {
            return null;
        }

        UserProfile profile = new UserProfile();
        profile.setId(user.getId());

        profile.setFullName(
                user.getLastName() + " " +
                        user.getFirstName() + " " +
                        user.getMiddleName()
        );

        profile.setDeliveryAddress(user.getDeliveryAddress());
        profile.setPhone(user.getPhone());
        profile.setEmail(user.getEmail());

        List<OrderInfo> orders = orderClient.getOrdersByUser(userId);

        UserFullInfo fullInfo = new UserFullInfo();
        fullInfo.setUserProfile(profile);
        fullInfo.setOrders(orders);

        return fullInfo;
    }
}