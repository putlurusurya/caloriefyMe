package com.CalorieCalculator.CaloriefyMe.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.CalorieCalculator.CaloriefyMe.Models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    User findByUsername(String username);
}
