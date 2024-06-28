package org.example.webservice_jax_rs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Path("/hello-world")
public class HelloResource extends Application {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    private static Map<Integer, String> dataStore = new HashMap<>();

    static {
        dataStore.put(1, "Item 1");
        dataStore.put(2, "Item 2");
        dataStore.put(3, "Item 3");
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

    @GET
    @Path("/doudou")
    @Produces(MediaType.TEXT_HTML)
    public String doudou() {
        String imageUrl = "https://media.licdn.com/dms/image/D4E03AQGMcDu--YhTfw/profile-displayphoto-shrink_800_800/0/1678898426700?e=1724284800&v=beta&t=q1TxiWlleqS1WJZuQYvcbuFHEcM1omN-0vq8N3bsIIs";
        return "<html>" +
                "<body>" +
                "<h1>DOUDOU</h1>" +
                "<img src=\"" + imageUrl + "\" alt=\"Image\">" +
                "</body>" +
                "</html>";
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
                return Response.status(Response.Status.CONFLICT)
                        .entity("Item with ID: " + id + " already exists.")
                        .build();
            }

            dataStore.put(id, value);
            return Response.status(Response.Status.CREATED)
                    .entity("Item added with ID: " + id )
                    .build();

        } catch (NumberFormatException | NullPointerException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid input. Please provide a valid 'id' and 'value'.")
                    .build();
        }
    }

    @POST
    @Path("/add-item-form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addItemForm(@FormParam("id") String idStr,
                                @FormParam("value") String value) {
        try {
            if (idStr == null || value == null) {
                throw new NullPointerException("ID or value is null");
            }

            int id = Integer.parseInt(idStr);

            if (dataStore.containsKey(id)) {
                return Response.status(Response.Status.CONFLICT)
                        .entity("Item with ID: " + id + " already exists.")
                        .build();
            }

            dataStore.put(id, value);
            return Response.status(Response.Status.CREATED)
                    .entity("Item added with ID: " + id)
                    .build();
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid input. 'id' must be a valid integer.")
                    .build();
        } catch (NullPointerException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid input. Please provide a valid 'id' and 'value'.")
                    .build();
        }
    }

    //    @POST
//    @Path("/upload-file")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response uploadFile(
//            @FormDataParam("file") InputStream fileInputStream,
//            @FormDataParam("file") FormDataContentDisposition contentDispositionHeader) {
//
//        String fileName = contentDispositionHeader.getFileName();
//
//        return Response.ok("Uploaded file name : " + fileName).build();
//    }
//

}
