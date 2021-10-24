package com.lbd.apiscanner;

import com.lbd.analyst.model.type.ObjectType;
import com.lbd.analyst.model.type.Type;

import java.util.Map;

/**
 * Rest Api描述
 */
public class ApiModel {
    private String url;
    private String method;
    private Map<String, Type> urlParameters;
    private ObjectType body;
    private Map<String, Type> headerParameters;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Type> getUrlParameters() {
        return urlParameters;
    }

    public void setUrlParameters(Map<String, Type> urlParameters) {
        this.urlParameters = urlParameters;
    }

    public ObjectType getBody() {
        return body;
    }

    public void setBody(ObjectType body) {
        this.body = body;
    }

    public Map<String, Type> getHeaderParameters() {
        return headerParameters;
    }

    public void setHeaderParameters(Map<String, Type> headerParameters) {
        this.headerParameters = headerParameters;
    }
}
