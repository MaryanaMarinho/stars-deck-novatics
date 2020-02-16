package com.maryana.starsdeck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StarsDeckBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarsDeckBackendApplication.class, args);
    }

}
