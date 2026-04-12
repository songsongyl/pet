package com.ruoyi.admin.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class StatusDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        if (value == null) {
            return null;
        }
        switch (value.toLowerCase()) {
            case "pending":
            case "待审核":
                return 0;
            case "active":
            case "正常合作":
                return 1;
            case "paused":
            case "暂停合作":
                return 2;
            case "terminated":
            case "终止合作":
                return 3;
            default:
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new IOException("Invalid status value: " + value);
                }
        }
    }
}
