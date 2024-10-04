package com.sevensolutions.digitalpoint;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DigitalPointApplication {
    public static void main(String[] args) {
        SpringApplication.run(DigitalPointApplication.class, args);
    }

    @Bean
    public CommandLineRunner initialization(){
        return  args -> {
            System.out.println("Ok");
        };
    }

}