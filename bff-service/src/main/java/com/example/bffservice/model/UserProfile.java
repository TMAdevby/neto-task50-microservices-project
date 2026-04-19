package com.example.bffservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private Long id;
    private String fullName;
    private String deliveryAddress;
    private String phone;
    private String email;
}
