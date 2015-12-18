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

    public boolean authenticate(String username, String password) {
        String userId = getUserId(username);
        boolean isCorrect = checkPassword(userId, password);
        return isCorrect;
    }

    @HystrixCommand(fallbackMethod = "getUserIdFallback")
    private String getUserId(String username) {
        throw new RuntimeException("username cannot be found");
    }
    
    private String getUserIdFallback(String username, Throwable e)
    {
        LOGGER.error(username, e);
        return "abc";
    }

    @HystrixCommand(fallbackMethod = "checkPasswordFallback")
    private boolean checkPassword(String userId, String password) {
        throw new RuntimeException("password doesn't match");
    }
    
    private boolean checkPasswordFallback(String userId, String password, Throwable e)
    {
        LOGGER.error(userId, e);
        return true;
    }
}
