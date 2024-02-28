package com.example.phonecircuitbreaker.phonepes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PhonepesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonepesApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
