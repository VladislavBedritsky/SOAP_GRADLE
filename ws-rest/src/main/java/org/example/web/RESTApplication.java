package org.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.*")
public class RESTApplication {
    public static void main(String[] args) {
        SpringApplication.run(RESTApplication.class, args);
    }
}
