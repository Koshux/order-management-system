package com.lanzonprojects.omsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DogBoxOMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogBoxOMSApplication.class, args);
    }
}
