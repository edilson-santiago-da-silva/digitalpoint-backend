package com.sevensolutions.digitalpoint.config;

import com.sevensolutions.digitalpoint.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    boolean instanceDB() throws Exception {
        if (value.equals("create")){
            this.dbService.instanceDB();
        }
        return false;
    }
}
