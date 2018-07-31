package com.segi.uhomecp.back.config;

import com.google.common.base.Strings;

import java.util.Map;

/**
 * Author: koabs
 * 2018/6/15.
 */
public class DumpConfig {

    public String binPath;
    public String month;
    public String exportFolder;
    public String conditions;

    public DumpConfig() {
    }

    public DumpConfig(String binPath, String month, String exportFolder, String  conditions) {
        this.binPath = binPath;
        this.month = month;
        this.exportFolder = exportFolder;
        this.conditions = conditions;
    }

    public static DumpConfig build(Map<String, Object> config){
        if (config == null)
            throw new RuntimeException("mysql.dump 未配置");
        DumpConfig dumpConfig = new DumpConfig();
        dumpConfig.binPath = String.valueOf(config.get("binPath"));
        dumpConfig.month = String.valueOf(config.get("month"));
        dumpConfig.exportFolder = String.valueOf(config.get("exportFolder"));
        dumpConfig.conditions = String.valueOf(config.get("conditions"));
        if (Strings.isNullOrEmpty(dumpConfig.binPath))
            throw new RuntimeException("mysql.dump.binPath 未配置");
        if (Strings.isNullOrEmpty(dumpConfig.month))
            throw new RuntimeException("mysql.dump.month 未配置");
        if (Strings.isNullOrEmpty(dumpConfig.exportFolder))
            throw new RuntimeException("mysql.dump.exportFolder 未配置");
        if (Strings.isNullOrEmpty(dumpConfig.conditions))
            throw new RuntimeException("mysql.dump.conditions 未配置");

        return dumpConfig;
    }
}
