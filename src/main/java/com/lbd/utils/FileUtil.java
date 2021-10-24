package com.lbd.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    /**
     * 会将{@paramref dir}下的所有以{@paramref suffix}为后缀的文件路径添加到{paramref filePathList}中
     *
     * @param dir 待反编译的目录
     * @param filePathList 待反编译文件的目录
     * @param suffix 文件后缀
     */
    public static void getFilesOfDir(File dir,List<File> filePathList,String suffix){
        if(!dir.exists()||!dir.isDirectory()){
            return;
        }
        if(suffix==null){
            return;
        }
        if(filePathList==null){
            return;
        }
        File[] files=dir.listFiles();
        for(File file:files){
            if(file.isFile()&&file.getName().endsWith(suffix)){
                filePathList.add(file);
            }
            if(file.isDirectory()){
                getFilesOfDir(file,filePathList,suffix);
            }
        }
    }

    /**
     * 判断是不是需要反编译的文件
     *
     * @param file 文件
     * @return 是否需要反编译
     */
    public static boolean isValidDecompileFile(File file){
        if(file==null){
            return false;
        }
        if(!file.isFile()){
            return false;
        }
        if(file.getName().endsWith(".jar")||file.getName().endsWith(".class")){
            return true;
        }
        return false;
    }
}
