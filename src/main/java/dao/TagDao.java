package dao;

//import api.TagResponse;
import api.ReceiptResponse;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.TAGS;
import static generated.Tables.RECEIPTS;

public class TagDao {
    DSLContext dsl;

    public TagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public void insert(int receiptId, String tagName) {
        List<TagsRecord> findTag = dsl.select().from(TAGS).where(TAGS.RECEIPT_ID.eq(receiptId).and(TAGS.TAG_NAME.eq(tagName))).fetchInto(TagsRecord.class);
        if (!findTag.isEmpty()) {
            dsl.deleteFrom(TAGS).where(TAGS.RECEIPT_ID.eq(receiptId).and(TAGS.TAG_NAME.eq(tagName))).execute();
        }
        else {
            TagsRecord tagsRecord = dsl
                    .insertInto(TAGS, TAGS.RECEIPT_ID, TAGS.TAG_NAME)
                    .values(receiptId, tagName)
                    .returning(TAGS.ID)
                    .fetchOne();
            checkState(tagsRecord != null, "Insert failed");
        }
    }

    public List<ReceiptsRecord> getAllReceiptsWithTag(String tagName) {
        return dsl.select().from(RECEIPTS)
                .join(TAGS)
                .on(TAGS.RECEIPT_ID.eq(RECEIPTS.ID).and(TAGS.TAG_NAME.eq(tagName)))
                .fetchInto(ReceiptsRecord.class);
    }

    public List<TagsRecord> getAllTagsWithReceipt(int receiptId) {
        return dsl.select().from(TAGS)
                .join(RECEIPTS)
                .on(RECEIPTS.ID.eq(TAGS.RECEIPT_ID).and(RECEIPTS.ID.eq(receiptId)))
                .fetchInto(TagsRecord.class);
    }
}