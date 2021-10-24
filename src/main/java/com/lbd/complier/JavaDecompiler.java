package com.lbd.complier;

import com.lbd.utils.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于进行Java反编译
 */
public interface JavaDecompiler {
     /**
      * 将一个jar文件反编译
      *
      * @param jarFile jar文件
      * @param outPutPath 保存反编译源码的路径
      */
     default void decompileJarFile(File jarFile,File outPutPath){
          decompile(jarFile, outPutPath);
     }

     /**
      * 将一个路径下jar文件反编译
      *
      * @param dirPath 含有Jar文件的路径
      * @param outPutPath 保存反编译源码的路径
      */
     default void decompileJarsOfDir(File dirPath, File outPutPath){
          List<File> pathList=new ArrayList<File>();
          FileUtil.getFilesOfDir(dirPath,pathList,".jar");
          for(File filePath:pathList){
               decompile(filePath,outPutPath);
          }
     }


     /**
      * 将一个路径下的class文件反编译
      *
      * @param classFile .class文件
      * @param outPutPath 保存反编译源码的路径
      */
     default void decompileClassFile(File classFile,File outPutPath){
          decompile(classFile, outPutPath);
     }

     /**
      * 将一个路径下class文件反编译
      *
      * @param dirPath 含有Jar文件的路径
      * @param outPutPath 保存反编译源码的路径
      */
     default void decompileClassOfDir(File dirPath, File outPutPath){
          List<File> pathList=new ArrayList<File>();
          FileUtil.getFilesOfDir(dirPath,pathList,".class");
          for(File filePath:pathList){
               decompile(filePath,outPutPath);
          }
     }

     /**
      * 将一个class或Jar文件反编译
      *
      * @param inputFile 个class或Jar文件反编译文件
      * @param outPutPath 保存反编译源码的路径
      */
     void decompile(File inputFile,File outPutPath);

     /**
      * 将一个路径下的class或jar文件反编译
      *
      * @param dirPath 路径
      * @param outPutPath 保存反编译源码的路径
      */
     default void decompileOfDir(File dirPath, File outPutPath){
          decompileJarsOfDir(dirPath,outPutPath);
          decompileClassOfDir(dirPath,outPutPath);
     }
}
