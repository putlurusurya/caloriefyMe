package com.CalorieCalculator.CaloriefyMe.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



@Service
public class NutritionService {

    @Value("$(caloriefyme.nutrition.api.url)")
    private String nutritionApiUrl;

    @Value("${caloriefyme.nutrition.api.appid}")
    private String APP_ID;

    @Value("${caloriefyme.nutrition.api.appkey}")
    private String APP_KEY;
    
    // private String nutritionApiUrl="https://api.nutritionix.com/v1_1/item" ;

    public String getNutritionFact(String foodName) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("x-app-id",APP_ID);
        headers.set("x-app-key",APP_KEY);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString("https://trackapi.nutritionix.com/v2/search/instant/?query="+foodName);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                String.class
        );

        return responseEntity.getBody();
    }
}

