package controllers;

import com.google.common.io.Resources;
import java.io.IOException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static java.nio.charset.StandardCharsets.UTF_8;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HtmlController {

    @GET
    public String getIndexPage() throws IOException {
            Resources.getResource("index.html");
//            Resources.getResource("style.css");
            return Resources.toString(Resources.getResource("index.html"), UTF_8);
        }
}