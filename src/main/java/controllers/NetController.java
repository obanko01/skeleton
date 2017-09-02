package controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/netId")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class NetController {

    @GET
    public String getNetID() {
        return "ob97";
    }



}

//    put request for adding tags to receipts
//@Path("/tags/:tag")
//public void toggleTag(@PathParam("tag") String tagName) {
//
//}
