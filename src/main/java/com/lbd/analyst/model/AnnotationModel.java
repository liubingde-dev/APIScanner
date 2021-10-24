package com.lbd.analyst.model;

import java.util.Map;

/**
 * Java注解描述
 */
public class AnnotationModel {
    private String name;
    private Map<String,String> paramters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getParamters() {
        return paramters;
    }

    public void setParamters(Map<String, String> paramters) {
        this.paramters = paramters;
    }
}
