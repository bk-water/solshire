package com.segi.uhomecp.back.manager;

import com.segi.uhomecp.back.JdbcConnection;
import com.segi.uhomecp.back.config.ConfigManager;
import com.segi.uhomecp.back.greenplum.GPManager;
import com.segi.uhomecp.back.mysql.DatabaseInfo;
import com.segi.uhomecp.back.mysql.Table;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author koabs
 * @Date 2018/6/13.
 * @Describe
 * 管理备份流程
 */
public class BackupManager {
//     scp root@47.75.10.26:/tmp/mysql-export-csv/user_permission.txt /Users/kevin1/Documents/Docker_Ext/greenplum-db-gpdb-sandbox-tutorials-d734733

    /**
     * 备份数据数据库信息
     * @throws IOException
     */
    public static void backup(String configPath) throws IOException, SQLException {
        String gpfdistUrl = "";
        String delimiter = "";
        // 初始化 配置信息
        ConfigManager configManager =  ConfigManager.instance(configPath);
        MonitorManager monitorDbManager = MonitorManager.instance(configManager.getMonitorDbManager(),"month");
        GPManager gpManager = GPManager.instance(configManager.getGpManager());
        for (JdbcConnection bconn: configManager.getBackupdbs()) {
            DatabaseInfo bdb = DatabaseInfo.instance(bconn);
            String backNum = "数据库信息+月份";
            // 获取所有配置的mysql 数据库信息 循环备份
            for (String tableName : configManager.getTableNames()) {
                Table table = bdb.getDbTableInfo(tableName);
                // 导出csv
                bdb.dumpTableDate(configManager.getDumpConfig(),tableName);
                String createGpExtTableSql = bdb.getCreateGPExternalTable(tableName,delimiter,gpfdistUrl);
                // 创建临时表
                gpManager.createExternalTable(createGpExtTableSql,tableName);
                // 导入数据
                gpManager.importDateFromExtTable(table,backNum);
                // 校验两边数据一致性(数目是否一致)

                // 备份成功
            }
        }

        // 全部备份完成后 发送备份情况邮件到指定邮箱
    }


    public static void main(String[] args) throws IOException, SQLException {
        BackupManager.backup("backup.yml");
//        // 导出数据成问题
//        MysqlDumpUtil.dumpMysqlData("47.75.10.26","3306","cyd1991","MY78sdQPl11!",
//                "/tmp/mysql-export-csv","201809","solshire","user_permission", "/usr/local/mysql/bin");
    }

}
