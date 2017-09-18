import controllers;


import io.dropwizard.jersey.validation.Validators;
import org.junit.Test;

import javax.validation.Validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;

public class NetIdRequestTest {

    private final Validator validator = Validators.newValidator();

    @Test
    public void testValid() {
        NetID = new NetController();

        CreateTagRequest tag = new CreateNETRequest();
        tag.tagName = "OBoi";

        tag.receiptId = 1;
        assertThat(validator.validate(tag), empty());
    }

    @Test
    public void testMissingResponse() {
        CreateTagRequest tag = new CreateTagRequest();
        tag.receiptId = 1;

        assertThat(validator.validate(tag), hasSize(0));
    }
}