package com.CalorieCalculator.CaloriefyMe.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.CalorieCalculator.CaloriefyMe.Models.User;
import com.CalorieCalculator.CaloriefyMe.Responses.ErrorResponse;
import com.CalorieCalculator.CaloriefyMe.Services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@RequestBody User user) {
        User newUser = userService.signUp(user);
        if(newUser==null){
            return  ResponseEntity.badRequest().body(new ErrorResponse("User not found"));
        }
        return ResponseEntity.ok().body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password) {
        User newUser = userService.login(username, password);

        return ResponseEntity.ok().body(newUser);
    }
}
