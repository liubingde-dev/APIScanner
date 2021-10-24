package com.lbd.analyst.model.type;

/**
 * 对拥有默认值这个能力进行定义
 */
public interface WithDefaultValue {
     /**
      * 获取默认值
      *
      * @return 默认值
      */
     String getDefaultValue();
}
