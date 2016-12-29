package com.jason.superframe.glideconfig;

/**
 * 项目名称：AndroidSuperFrame
 * 〈配置信息〉
 * 〈配置信息〉
 * 创建人：JasonGao
 * 创建日期：2016/12/29.10:34
 */

public class ConfigConstants {
    public static final int MAX_HEAP_SIZE = (int) Runtime.getRuntime().maxMemory();
    public static final int MAX_CACHE_MEMORY_SIZE = MAX_HEAP_SIZE / 4;
    public static final int MAX_CACHE_DISK_SIZE = 50 * 1024 * 1024;
}
