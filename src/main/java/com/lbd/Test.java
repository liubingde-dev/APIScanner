package com.lbd;

import com.github.javaparser.JavaParser;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.lbd.utils.FileUtil;
import com.thoughtworks.qdox.JavaProjectBuilder;
import org.checkerframework.checker.units.qual.C;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Test {
    public static void main(String[] argvs) throws IOException {
        JarFile jarFile=new JarFile("/home/liubingde/Downloads/litemall-master/litemall-master/litemall-wx-api/target/litemall-wx-api-0.1.0.jar");
        Enumeration<JarEntry> jarEntryEnumeration= jarFile.entries();
        while (jarEntryEnumeration.hasMoreElements()){
            JarEntry jarEntry=jarEntryEnumeration.nextElement();
            Attributes attributes=jarEntry.getAttributes();
            System.out.println();
        }
        test();
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        javaProjectBuilder.addSource(new File("/home/liubingde/Downloads/litemall-master/litemall-master/litemall-wx-api/src/main/java/org/linlinjava/litemall/wx/web/WxAftersaleController.java"));
        javaProjectBuilder.getClasses().forEach(javaClass -> {
            javaClass.getAnnotations();
            System.out.println();
        });
        List<File> fileList = new ArrayList<>();
        FileUtil.getFilesOfDir(new File("/home/liubingde/Downloads/litemall-master/litemall-master/litemall-all-war/target/litemall/WEB-INF/lib/"), fileList, ".jar");
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());
        for(File file:fileList){
            combinedTypeSolver.add(new JarTypeSolver(file));
        }

                JavaParser javaParser = new JavaParser();
        javaParser.getParserConfiguration().setSymbolResolver(new JavaSymbolSolver(combinedTypeSolver));
        CompilationUnit compilationUnit = javaParser.parse(new File("/home/liubingde/Downloads/litemall-master/litemall-master/litemall-wx-api/src" +
                "/main/java/org/linlinjava/litemall/wx/web/WxAftersaleController.java")).getResult().get();
        compilationUnit.findAll(MarkerAnnotationExpr.class).forEach(markerAnnotationExpr -> {
            ResolvedType resolvedType=markerAnnotationExpr.calculateResolvedType();
            System.out.println(markerAnnotationExpr.toString()+" type is:"+resolvedType);
        });
        System.out.println();

    }
    public static void  test(){
        // Set up a minimal type solver that only looks at the classes used to run this sample.
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        // Configure JavaParser to use type resolution
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);

        // Parse some code
        CompilationUnit cu = StaticJavaParser.parse("class X { int x() { return 1 + 1.0 - 5; } }");

        // Find all the calculations with two sides:
        cu.findAll(BinaryExpr.class).forEach(be -> {
            // Find out what type it has:
            ResolvedType resolvedType = be.calculateResolvedType();

            // Show that it's "double" in every case:
            System.out.println(be.toString() + " is a: " + resolvedType);
        });
    }
}
