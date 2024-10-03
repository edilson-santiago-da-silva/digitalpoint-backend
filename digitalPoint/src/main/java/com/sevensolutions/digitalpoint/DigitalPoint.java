package com.sevensolutions.digitalpoint;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DigitalPoint {
    public static void main(String[] args) {
        SpringApplication.run(DigitalPoint.class, args);
    }

    @Bean
    public CommandLineRunner initialization(){
        return  args -> {
            System.out.println("Ok");
        };
    }

}