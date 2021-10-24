package com.lbd.analyst.model;

import java.util.List;

/**
 * Java方法定义
 */
public class MethodModel {
    private String name;
    private List<AnnotationModel> annotationModelList;
    private List<ParameterModel> parameterModelList;

    public List<ParameterModel> getParameterModelList() {
        return parameterModelList;
    }

    public void setParameterModelList(List<ParameterModel> parameterModelList) {
        this.parameterModelList = parameterModelList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnnotationModel> getAnnotationModelList() {
        return annotationModelList;
    }

    public void setAnnotationModelList(List<AnnotationModel> annotationModelList) {
        this.annotationModelList = annotationModelList;
    }
}
