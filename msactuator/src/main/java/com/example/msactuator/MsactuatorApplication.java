package com.example.msactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MsactuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsactuatorApplication.class, args);
    }
    @RequestMapping("/")
    String home() {
        return "Hello-World!";
    }

}
