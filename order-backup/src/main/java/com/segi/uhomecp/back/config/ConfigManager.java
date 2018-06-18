package com.segi.uhomecp.back.config;

import com.segi.uhomecp.back.greenplum.GPManager;
import com.segi.uhomecp.back.mysql.DatabaseInfo;

import java.util.List;

/**
 * Author: koabs
 * 2018/6/15.
 */
public class ConfigManager {

    private List<DatabaseInfo> backupdbs;

    private GPManager gpManager;

    public static ConfigManager instance = null;

    private ConfigManager() {
    }

    private static ConfigManager instance() {
        // 启动参数传入或者环境变量
        String path = "";

        return null;
    }

}
