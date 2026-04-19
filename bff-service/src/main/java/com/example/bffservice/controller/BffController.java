package com.example.bffservice.controller;

import com.example.bffservice.client.OrderClient;
import com.example.bffservice.client.UserClient;
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

        UserProfile userProfile = userClient.getUserProfile(userId);

        if (userProfile == null) {
            return null;
        }

        List<OrderInfo> orders = orderClient.getOrdersByUser(userId);

        UserFullInfo fullInfo = new UserFullInfo();
        fullInfo.setUserProfile(userProfile);
        fullInfo.setOrders(orders);

        return fullInfo;
    }
}
