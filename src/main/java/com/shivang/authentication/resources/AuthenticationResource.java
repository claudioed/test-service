package com.shivang.authentication.resources;

import com.shivang.authentication.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@EnableAutoConfiguration
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationResource.class);
    
    @Autowired
    private AuthenticationService authService;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticate(@FormParam("username") String username, @FormParam("password") String password) {
        boolean isAuthenticated = authService.authenticate(username, password);
        Map success = new HashMap<>();
        success.put("success", isAuthenticated);
        LOGGER.info("response: {}", success.toString());
        return Response.status(HttpStatus.OK.value()).entity(success).build();
    }
}
