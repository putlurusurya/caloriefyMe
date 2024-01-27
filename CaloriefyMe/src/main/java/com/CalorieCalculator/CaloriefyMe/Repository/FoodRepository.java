package com.CalorieCalculator.CaloriefyMe.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.CalorieCalculator.CaloriefyMe.Models.Food;

public interface FoodRepository extends MongoRepository<Food, String>{
    
}
