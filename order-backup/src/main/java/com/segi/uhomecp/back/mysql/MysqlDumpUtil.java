package com.segi.uhomecp.back.mysql;

import com.google.common.base.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @Author koabs
 * @Date 2018/6/13.
 * @Describe
 * 导出csv 数据
 *
 */
public class MysqlDumpUtil {


    /***
     * 导出无数据 待观察
     * 和如何确认导出是否成功
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param exportFolder
     * @param partitionMonth
     * @param schema
     * @param tableName
     * @param mysqldumpPath
     * @throws IOException
     */
    // mysqldump --skip-lock-tables -h47.75.10.26 -P3306 -ucyd1991 -pMY78sdQPl11! -w 'id=4'  -t  -T/tmp/mysql-export-csv solshire user_permission --fields-terminated-by=','
    public static void dumpMysqlData(String ip,String port,String username,String password,
                                     String exportFolder,String partitionMonth,String schema,
                                     String tableName,String mysqldumpPath) throws IOException {
        String path;
        if (!Strings.isNullOrEmpty(exportFolder)) {
            path = exportFolder + "/" + ip + "/" + schema + "/" + tableName + "/" + partitionMonth;
            Runtime.getRuntime().exec("rm -rf " + path);
            Runtime.getRuntime().exec("mkdir -p " + path);
        } else {
            throw new RuntimeException("exportFolder 路径不能为null");
        }
        System.out.println("导出路径:" + path);
        String commandStr = mysqldumpPath + "/mysqldump --skip-lock-tables -h" +
                ip + " -P" + port + " -u" + username + " -p" + password + " -w 'id=4'  -t  -T" +
                path + " " + schema + " " + tableName + " --fields-terminated-by=','";
        // 导出时先删除目录和里面文件再新建目录
        System.out.println(commandStr);
        Process p = Runtime.getRuntime().exec(commandStr);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
        StringBuffer sb = new StringBuffer();
        String s;
        while((s=br.readLine()) != null){
            sb.append(s+"\n");
        }
        System.out.println("导出成功" + sb.toString());
    }
}
