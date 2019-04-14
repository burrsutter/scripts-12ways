package org.acme.rest;

// import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class MyREST {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String index() {
      return "Hello";
  }
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/{name}")
  public String greeting(@PathParam("name") String name) {
      return "Hello " + name;
  }

}

