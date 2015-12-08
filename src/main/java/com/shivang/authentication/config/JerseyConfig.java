package com.shivang.authentication.config;

import com.shivang.authentication.resources.BaseResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/authentication-service")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        super();
        register(BaseResource.class);
    }
}
