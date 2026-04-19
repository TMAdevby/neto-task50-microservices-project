package com.example.bffservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFullInfo {

    private UserProfile userProfile;

    private List<OrderInfo> orders;
}
