package com.lbd.complier;

import com.lbd.utils.CommandExcUtil;
import com.lbd.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用JADX进行反编译
 */
public class JADXDecompiler implements JavaDecompiler {
    private static final String JADX_COMMAND_FORMAT = "%sjadx -r -d %s %s";

    private String jadxPath = "";//TODO

    public void decompile(File inputFile, File outPutPath) {
        if (!inputFile.exists() || !inputFile.isFile()) {
            return;
        }
        if (!FileUtil.isValidDecompileFile(inputFile)) {
            return;
        }
        try {
            CommandExcUtil.runCommand(String.format(JADX_COMMAND_FORMAT, jadxPath, outPutPath.getCanonicalPath(), inputFile.getCanonicalPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置jadx的运行目录，默认为当前目录
     *
     * @param jadxPath jadx运行目录
     */
    public void setJadxPath(String jadxPath) {
        this.jadxPath = jadxPath;
    }
}
