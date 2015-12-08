package com.shivang.authentication.resources;

import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import org.springframework.stereotype.Component;

@Component
@Path("")
public class BaseResource {

    @Context
    private ResourceContext resourceContext;

    @Path("/authenticate")
    public AuthenticationResource getAuthenticationResource() {
        return resourceContext.getResource(AuthenticationResource.class);
    }
}
