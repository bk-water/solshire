package com.segi.uhomecp.back.config;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import com.segi.uhomecp.back.JdbcConnection;
import com.segi.uhomecp.back.greenplum.GPManager;
import com.segi.uhomecp.back.manager.MonitorDbManager;
import com.segi.uhomecp.back.mysql.DatabaseInfo;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: koabs
 * 2018/6/15.
 */
public class ConfigManager {

    private List<JdbcConnection> backupdbs;

    private JdbcConnection gpManager;

    private JdbcConnection monitorDbManager;

    private DumpConfig dumpConfig;

    private List<String> tableNames;

    public static ConfigManager instance = null;

    private ConfigManager() {
    }

    public static ConfigManager instance(String ymalPath) throws IOException {
        if (instance==null) {
            // 启动参数传入或者环境变量
            Yaml yaml = new Yaml();
            Map<String, Object> ymalMap = null;
            InputStream is = Resources.getResource(ymalPath).openStream();
            if (is != null) {
                ymalMap = yaml.load(is);
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException("backup.yml 配置文件加载出错");
                }
            } else {
                throw new RuntimeException("backup.yml 配置文件不存在.");
            }
            instance =  ConfigManager.parse(ymalMap);
        }
        return instance;
    }

    private static ConfigManager parse(Map<String, Object> ymalMap) {
        ConfigManager configManager = new ConfigManager();
        Map<String, Object> mysqlMap = (Map<String, Object>) ymalMap.get("mysql");
        if (mysqlMap==null)
            throw new RuntimeException("mysql: 节点属性未配置");
        Map<String, Object> dumpMap = (Map<String, Object>)mysqlMap.get("dump");
        configManager.dumpConfig = DumpConfig.build(dumpMap);
        String tableNames = String.valueOf(mysqlMap.get("tables"));
        if (Strings.isNullOrEmpty(tableNames))
            throw new RuntimeException("mysql.tables: 节点属性未配置示例 table1,table2,table3 ");
        configManager.tableNames = Lists.newArrayList(tableNames.split(","));
        // 解析所有要备份的数据库
        List<Map<String,Object>> backupdbs = (List<Map<String, Object>>) mysqlMap.get("backupdbs");
        configManager.backupdbs = new ArrayList<>();
        for (Map<String,Object> backupdb : backupdbs) {
            configManager.backupdbs.addAll(JdbcConnection.buildBackup(backupdb));
        }

        configManager.monitorDbManager = JdbcConnection.buildMonitir((Map<String, Object>)mysqlMap.get("monitordb"));
        Map<String, Object> gpMap = (Map<String, Object>) ymalMap.get("greenplum");
        configManager.gpManager = JdbcConnection.buildGP(gpMap);
        return configManager;
    }

    public List<JdbcConnection> getBackupdbs() {
        return backupdbs;
    }

    public JdbcConnection getGpManager() {
        return gpManager;
    }

    public JdbcConnection getMonitorDbManager() {
        return monitorDbManager;
    }

    public DumpConfig getDumpConfig() {
        return dumpConfig;
    }

    public List<String> getTableNames() {
        return tableNames;
    }
}
