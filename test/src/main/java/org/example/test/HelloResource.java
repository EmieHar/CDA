package org.example.test;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.Map;
import java.util.HashMap;

@Path("/hello-world")
public class HelloResource {


    private static Map<Integer, String> dataStore = new HashMap<>();

    static {
        dataStore.put(1, "Item 1");
        dataStore.put(2, "Item 2");
        dataStore.put(3, "Item 3");
    }


    @GET
    @Path("/toto")
    @Produces("text/plain")
    public String toto() {
        return "Hello, toto!";
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getDefaultMessage() {
        return "Hello, this is the default message!";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemById(@PathParam("id") int id) {
        String item = dataStore.get(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Item not found for ID: " + id)
                    .build();
        }
        return Response.ok(item).build();
    }

    @POST
    @Path("/add-item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItem(Map<String, String> item) {
        try {
            String idStr = item.get("id");
            String value = item.get("value");

            int id = Integer.parseInt(idStr);

            if (dataStore.containsKey(id)) {
                return Response.status(Status.CONFLICT)
                        .entity("Item with ID: " + id + " already exists.")
                        .build();
            }

            dataStore.put(id, value);
            return Response.status(Status.CREATED)
                    .entity("Item added with ID: " + id + ".")
                    .build();

        } catch (NumberFormatException | NullPointerException e) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Invalid input. Please provide a valid 'id' and 'value'.")
                    .build();
        }
    }

}