package com.shivang.authentication.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

    public AuthenticationService() {

    }

    @HystrixCommand(fallbackMethod = "authenticationFallback")
    public boolean authenticate(String username, String password) {
        if(username == null || password == null)
        {
            throw new RuntimeException("username and/or password not provided");
        }
        return true;
    }
    
    public boolean authenticationFallback(String username, String password, Throwable e)
    {
        LOGGER.error("authentication fallback called", e);
        return false;
    }
}
