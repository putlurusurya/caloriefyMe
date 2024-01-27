package com.CalorieCalculator.CaloriefyMe.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ClassifiyService {
    @Value("${caloriefyme.dl.api.url}")
    private String flaskAppUrl;

    


    public String forwardFileToFlask(MultipartFile file) throws IOException {
        System.out.println("Printing flask app URL in next line");
        System.out.println(flaskAppUrl);

        File convertedFile = convertMultiPartToFile(file);

        FileSystemResource fileResource = new FileSystemResource(convertedFile);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("file", fileResource);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(parts, headers);

        // String flaskAppUrl = "http://localhost:5000/predict";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> prediction = restTemplate.postForEntity(flaskAppUrl+"/predict", requestEntity, String.class);
        return prediction.getBody();
    }
    public File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File file = File.createTempFile("temp", null);
        try (var outputStream = Files.newOutputStream(file.toPath())) {
            outputStream.write(multipartFile.getBytes());
        }
        return file;
    }
    /*
    // Test function
    public String forFileTest(){
        String filePath = "341.jpg";

        String flaskUrl = "http://localhost:5000/predict";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        FileSystemResource fileResource = new FileSystemResource(new File(filePath));


        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("file", fileResource);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(parts, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, requestEntity, String.class);

        return response.getBody();
    
    }
    */
}
