package com.lbd.analyst;

import com.lbd.analyst.model.AnnotationModel;
import com.lbd.analyst.model.ClassModel;
import com.lbd.analyst.model.MethodModel;
import com.lbd.analyst.model.ParameterModel;
import com.lbd.common.ApiScannerException;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Qdox使用封装
 */
public class QdoxHelper {
    private JavaProjectBuilder javaProjectBuilder;

    public QdoxHelper(File sourceDir) {
        if (!sourceDir.isDirectory()) {
            throw new ApiScannerException();
        }
        this.javaProjectBuilder = new JavaProjectBuilder();
        this.javaProjectBuilder.addSourceTree(sourceDir);
    }

    /**
     * 获取所有的class内容
     *
     * @return 所有的class信息
     */
    public List<ClassModel> getClassModelList() {
        List<ClassModel> classModelList = new ArrayList<>();
        javaProjectBuilder.getClasses().forEach(javaClass -> {
            classModelList.add(toClassModel(javaClass));
        });
        return classModelList;
    }

    /**
     * 方法类转换
     *
     * @param javaMethod qdox的方法类型
     * @return MethodModel
     */
    private MethodModel toMethodModel(JavaMethod javaMethod) {
        MethodModel methodModel = new MethodModel();
        methodModel.setName(javaMethod.getName());

        List<ParameterModel> parameterModelList = new ArrayList<>();
        javaMethod.getParameters().forEach(javaParameter -> {
            parameterModelList.add(toParameterModel(javaParameter));
        });
        methodModel.setParameterModelList(parameterModelList);

        List<AnnotationModel> annotationModelList = new ArrayList<>();
        javaMethod.getAnnotations().forEach(javaAnnotation -> {
            annotationModelList.add(toAnnotationModel(javaAnnotation));
        });
        methodModel.setAnnotationModelList(annotationModelList);
        return methodModel;
    }

    /**
     * 注解类转换
     *
     * @param javaAnnotation Qbox注解类
     * @return 注解类
     */
    private AnnotationModel toAnnotationModel(JavaAnnotation javaAnnotation) {
        AnnotationModel annotationModel = new AnnotationModel();
        annotationModel.setName(javaAnnotation.getType().getName());
        Map<String, String> stringStringMap = new HashMap<>();
        Map<String, Object> namedParamterMap = javaAnnotation.getNamedParameterMap();
        namedParamterMap.forEach((s, o) -> {
            stringStringMap.put(s, o.toString());
        });
        annotationModel.setParamters(stringStringMap);
        return annotationModel;
    }

    private ParameterModel toParameterModel(JavaParameter javaParameter) {
        ParameterModel parameterModel = new ParameterModel();
        parameterModel.setName(javaParameter.getName());
        parameterModel.setClassModel(toClassModelOfParam(javaParameter.getJavaClass()));
        return parameterModel;
    }

    private ClassModel toClassModelOfParam(JavaClass javaClass){
        ClassModel classModel = new ClassModel();
        classModel.setName(javaClass.getName());
        classModel.setFullyQualifiedName(javaClass.getFullyQualifiedName());
        return classModel;
    }
    private ClassModel toClassModel(JavaClass javaClass) {
        ClassModel classModel = new ClassModel();
        classModel.setName(javaClass.getName());
        classModel.setFullyQualifiedName(javaClass.getFullyQualifiedName());
        List<AnnotationModel> annotationModelList = new ArrayList<>();
        javaClass.getAnnotations().forEach(javaAnnotation -> {
            annotationModelList.add(toAnnotationModel(javaAnnotation));
        });
        classModel.setAnnotationModelList(annotationModelList);

        List<MethodModel> methodModelList = new ArrayList<>();
        javaClass.getMethods().forEach(javaMethod -> {
            methodModelList.add(toMethodModel(javaMethod));
        });
        classModel.setMethodModelList(methodModelList);
        return classModel;
    }
}
