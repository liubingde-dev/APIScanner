package com.lbd.complier;

import com.lbd.utils.CommandExcUtil;
import com.lbd.utils.FileUtil;

import java.io.File;
import java.io.IOException;

public class CFRDecompiler implements JavaDecompiler {
    private static final String CFR_COMMAND_FORMAT = "%s -jar %s --outputdir %s %s ";
    private String javaPath = "java";
    private String crfPath = "cfr-0.151.jar";

    @Override
    public void decompile(File inputFile, File outPutPath) {
        if (!inputFile.exists() || !inputFile.isFile()) {
            return;
        }
        if (!FileUtil.isValidDecompileFile(inputFile)) {
            return;
        }
        try {
            CommandExcUtil.runCommand(String.format(CFR_COMMAND_FORMAT, javaPath, crfPath,
                    outPutPath.getCanonicalPath(), inputFile.getCanonicalPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }

    public void setCrfPath(String crfPath) {
        this.crfPath = crfPath;
    }
}
