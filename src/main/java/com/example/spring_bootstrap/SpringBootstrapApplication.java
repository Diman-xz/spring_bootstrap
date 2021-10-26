package com.example.spring_bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.spring_bootstrap")
public class SpringBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootstrapApplication.class, args);
    }

}
