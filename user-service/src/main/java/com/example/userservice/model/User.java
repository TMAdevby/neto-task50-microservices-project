package com.example.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;


    private String lastName;

    private String firstName;

    private String middleName;

    private String deliveryAddress;

    private String phone;

    private String email;
}