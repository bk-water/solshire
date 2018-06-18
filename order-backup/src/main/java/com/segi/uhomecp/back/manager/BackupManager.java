package com.segi.uhomecp.back.manager;

import com.segi.uhomecp.back.mysql.MysqlDumpUtil;

import java.io.IOException;

/**
 * @Author koabs
 * @Date 2018/6/13.
 * @Describe
 * 管理备份流程
 */
public class BackupManager {
//     scp root@47.75.10.26:/tmp/mysql-export-csv/user_permission.txt /Users/kevin1/Documents/Docker_Ext/greenplum-db-gpdb-sandbox-tutorials-d734733

    public static void init() {
        // 初始化 配置信息

        // 获取所有配置的mysql 数据库信息 循环备份

    }


    public static void main(String[] args) throws IOException {
        // 导出数据成问题
        MysqlDumpUtil.dumpMysqlData("47.75.10.26","3306","cyd1991","MY78sdQPl11!",
                "/tmp/mysql-export-csv","201809","solshire","user_permission", "/usr/local/mysql/bin");

    }

}
