package com.example.shortenurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// database -> entity -> repositories -> services -> controllers -> view/json
// database -> entity -> repositories -> services -> DTO <- controllers -> view/json
@SpringBootApplication
public class ShortenURLApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortenURLApplication.class, args);
    }

}
