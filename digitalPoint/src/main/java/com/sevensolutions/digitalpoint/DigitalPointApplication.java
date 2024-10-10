package com.sevensolutions.digitalpoint;

import java.util.Arrays;

import com.sevensolutions.digitalpoint.domain.Point;
import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.domain.enums.Profile;
import com.sevensolutions.digitalpoint.repositores.PointRepository;
import com.sevensolutions.digitalpoint.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

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