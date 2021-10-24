package com.lbd.apiscanner;

import java.io.File;
import java.util.List;

/**
 * 对api进行扫描
 * 1、获取指定目录代码里的接口列表
 * 2、接口列表带请求参数和请求体
 * 3、扫描目录指定包前缀
 * 4、
 */
public interface IApiScanner {
    List<ApiModel> getApiList();
}
