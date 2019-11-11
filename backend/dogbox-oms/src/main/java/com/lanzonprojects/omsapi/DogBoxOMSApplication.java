package com.lanzonprojects.omsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages={"com.lanzonprojects.omsapi"})
@EnableTransactionManagement
public class DogBoxOMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogBoxOMSApplication.class, args);
    }
}
