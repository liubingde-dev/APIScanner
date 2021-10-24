package com.lbd.utils;

import java.io.IOException;

/**
 * 系统命令执行工具
 */
public class CommandExcUtil {
    /**
     * 执行系统命令
     *
     * @param command 系统命令
     */
    public static void runCommand(String command){
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
