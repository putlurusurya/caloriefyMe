package com.CalorieCalculator.CaloriefyMe.Models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {
    @Id
    private String userId;
    private String username;
    private String weight;
    private String password;
}
