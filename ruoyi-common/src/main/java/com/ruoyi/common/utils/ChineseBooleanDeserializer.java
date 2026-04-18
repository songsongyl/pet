package com.ruoyi.common.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

/**
 * 自定义反序列化器，用于处理中文"是/否"到Integer的转换
 * "是" -> 1, "否" -> 0, "有" -> 1, "无" -> 0, 同时支持直接的整数值
 */
public class ChineseBooleanDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        if ("是".equals(value) || "有".equals(value)) {
            return 1;
        } else if ("否".equals(value) || "无".equals(value)) {
            return 0;
        } else {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new IOException("Invalid value for Integer: " + value + ". Expected '是', '否', '有', '无', or a number.", e);
            }
        }
    }
}
