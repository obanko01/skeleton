package controllers;

import api.CreateTagRequest;
import api.ReceiptResponse;
import dao.TagDao;
import generated.tables.records.ReceiptsRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags/{tag}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagController {
    final TagDao tags;

    public TagController(TagDao tags) {
        this.tags = tags;
    }

    @PUT
    public void toggleTag(CreateTagRequest tag, @PathParam("tag") String tagName) {
        tags.insert(tag.receiptId, tagName);
    }

    @GET
    public List<ReceiptResponse> getReceipts(@PathParam("tag") String tag) {
        List<ReceiptsRecord> receiptRecords = tags.getAllReceiptsWithTag(tag);
        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }


}

