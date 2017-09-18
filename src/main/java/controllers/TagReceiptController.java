package controllers;

import api.TagResponse;
import dao.TagDao;
import generated.tables.records.TagsRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("receipt/tags/{receiptId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagReceiptController {
    final TagDao tags;

    public TagReceiptController(TagDao tags) {
        this.tags = tags;
    }


    @GET
    public List<TagResponse> getAllTagsWithReceipt(@PathParam("receiptId") int receiptId) {
        List<TagsRecord> tagRecords = tags.getAllTagsWithReceipt(receiptId);
        return tagRecords.stream().map(TagResponse::new).collect(toList());
    }


}

