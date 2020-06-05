package org.example.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.*")
public class SOAPApplication {
    public static void main(String[] args) {
        SpringApplication.run(SOAPApplication.class, args);
    }
}
