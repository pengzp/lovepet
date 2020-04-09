package com.pet.lovepet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.pet.lovepet.dao.mapper",sqlSessionFactoryRef = "SqlSessionFactory")
public class LovepetApplication {

    public static void main(String[] args) {
        SpringApplication.run(LovepetApplication.class, args);
    }

}
