package com.lbd.apiscanner;

import com.lbd.analyst.IJavaCodeAnalyst;
import com.lbd.analyst.JavaCodeAnalyst;
import com.lbd.analyst.model.ClassModel;

import java.io.File;
import java.util.List;

public class ApiScanner implements IApiScanner {
    private IJavaCodeAnalyst javaCodeAnalyst;

    public ApiScanner(File dir) {
        this.javaCodeAnalyst = new JavaCodeAnalyst(dir);
    }

    @Override
    public List<ApiModel> getApiList() {
        List<ClassModel> classModelList=javaCodeAnalyst.getClassListHasApi();

        return null;
    }

    private ApiModel toApiModel(ClassModel classModel){
        ApiModel apiModel=new ApiModel();
        classModel.getAnnotationModelList().forEach(annotationModel -> {
            if(annotationModel.getName().equals("RequestMapping")){

            }
        });
        return apiModel;
    }
}
