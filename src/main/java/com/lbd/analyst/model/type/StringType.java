package com.lbd.analyst.model.type;

/**
 * 字符串类型
 */
public class StringType  extends BasicType{
    @Override
    public String getDefaultValue() {
        return "\"value\"";
    }
}
