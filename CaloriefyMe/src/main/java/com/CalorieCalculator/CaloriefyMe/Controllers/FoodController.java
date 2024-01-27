package com.CalorieCalculator.CaloriefyMe.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CalorieCalculator.CaloriefyMe.Services.ClassifiyService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;



@RestController
@RequestMapping("/calcalorie")

public class FoodController {

    @Autowired
    private ClassifiyService classifyService;

    // @Autowired
    // private NutritionService nutritionService;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestPart("file") MultipartFile file) throws IOException {
        // Forward the file to the Python Flask application
        String prediction = classifyService.forwardFileToFlask(file);
        //String getNutritionInfo = nutritionService.getNutritionFact(prediction);

        return ResponseEntity.ok(prediction);
    }

    
    

    @GetMapping("/getCalories")
    public ResponseEntity<Object> getTotalCalories(@RequestParam String param) {
        return null ;
    }
}
