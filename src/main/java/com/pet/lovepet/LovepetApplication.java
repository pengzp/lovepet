package com.pet.lovepet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class LovepetApplication {

    public static void main(String[] args) {
        SpringApplication.run(LovepetApplication.class, args);
    }

}
