package com.lbd.analyst.model.type;

/**
 * 小数类型
 */
public class DecimalType  extends BasicType{
    @Override
    public String getDefaultValue() {
        return "0.00";
    }
}
