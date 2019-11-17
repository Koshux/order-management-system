package com.lanzonprojects.omsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.lanzonprojects.omsapi")
public class DogBoxOMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(DogBoxOMSApplication.class, args);
    }
}
