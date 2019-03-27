package com.burrsutter.eventing;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class EventingResource {
    int cnt = 0;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String handleEvent(String body) {
        System.out.println("\n" + cnt++ + " *** " + body + "***\n");
        return "OK";
    }

    @GET
    @Path("/healthz")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthz() {
        return "OK";
    }


}