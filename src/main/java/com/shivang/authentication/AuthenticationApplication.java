package com.shivang.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class AuthenticationApplication {

    protected AuthenticationApplication() {}

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
