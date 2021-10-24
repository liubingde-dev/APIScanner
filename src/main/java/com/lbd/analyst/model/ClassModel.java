package com.lbd.analyst.model;

import java.util.List;

/**
 * 对一个类的定义，它会包含注解、方法、名称
 */
public class ClassModel {
    private List<AnnotationModel> annotationModelList;
    private List<MethodModel> methodModelList;
    private String name;
    private String fullyQualifiedName;

    public List<AnnotationModel> getAnnotationModelList() {
        return annotationModelList;
    }

    public void setAnnotationModelList(List<AnnotationModel> annotationModelList) {
        this.annotationModelList = annotationModelList;
    }

    public List<MethodModel> getMethodModelList() {
        return methodModelList;
    }

    public void setMethodModelList(List<MethodModel> methodModelList) {
        this.methodModelList = methodModelList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    public void setFullyQualifiedName(String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }
}
