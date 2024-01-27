package com.CalorieCalculator.CaloriefyMe.Models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Food {
	@Id
	private String foodId;

	private String userId;
    private int allCalories;
	
	private int proteinCalories;
	private int proteinGram;
	
	private int fatCalories;
	private int fatGram;
	
	private int carbohydratCalories;
	private int carbohydratGram;
}
