package com.lbd.analyst;

import com.lbd.analyst.model.ClassModel;

import java.util.List;
import java.util.Optional;

/**
 * 对代码进行分析
 * 1、类的所有注解
 * 2、获取类的指定方法的注解
 */
public interface IJavaCodeAnalyst {

    Optional<ClassModel> getClassModel(String fullName);

    List<ClassModel> getClassListHasApi();

}
