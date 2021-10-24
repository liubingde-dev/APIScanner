package com.lbd.analyst;

import com.lbd.analyst.model.AnnotationModel;
import com.lbd.analyst.model.ClassModel;
import com.lbd.analyst.model.MethodModel;
import com.lbd.common.ApiScannerException;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.lbd.common.ApiAnnotationConstants.CONTROLLER;
import static com.lbd.common.ApiAnnotationConstants.REST_CONTROLLER;

public class JavaCodeAnalyst implements IJavaCodeAnalyst {
    private final List<ClassModel> classModels;

    private QdoxHelper qdoxHelper;

    public JavaCodeAnalyst(File codeDir) {
        if (!codeDir.isDirectory()) {
            throw new ApiScannerException();
        }
        this.qdoxHelper = new QdoxHelper(codeDir);
        this.classModels = qdoxHelper.getClassModelList();
    }

    @Override
    public Optional<ClassModel> getClassModel(String fullName) {
        for (ClassModel classModel : classModels) {
            if (classModel.getFullyQualifiedName().equals(fullName)) {
                return Optional.of(classModel);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<ClassModel> getClassListHasApi() {
        List<ClassModel> classModelList = new ArrayList<>();
        for (ClassModel classModel : classModels) {
            if (isClassHasApi(classModel)) {
                classModelList.add(classModel);
            }
        }
        return classModelList;
    }

    private boolean isClassHasApi(ClassModel classModel) {
        for (AnnotationModel annotationModel : classModel.getAnnotationModelList()) {
            if (annotationModel.getName().equals(REST_CONTROLLER) || annotationModel.getName().endsWith(CONTROLLER)) {
                return true;
            }
        }
        return false;
    }
}
