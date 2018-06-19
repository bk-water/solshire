package com.segi.uhomecp.back;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: koabs
 * 2018/6/14.
 */
public class JdbcConnection {
    Connection conn = null;

    public String classDriver;
    public String url;
    public String username;
    public String password;
    public String schema;
    public String ip;
    public String port;


    public JdbcConnection() {
    }

    public JdbcConnection(String classDriver, String url, String username, String password) {
        super();
        this.classDriver = classDriver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public JdbcConnection(String classDriver, String url, String username, String password, String schema,String ip,String port) {
        super();
        this.classDriver = classDriver;
        this.url = url;
        this.username = username;
        this.password = password;
        this.schema = schema;
        this.ip = ip;
        this.port = port;
    }

    public static List<JdbcConnection> buildBackup(Map<String,Object> config) {
        List<JdbcConnection> list = new ArrayList<>();
        String schemas = String.valueOf(config.get("schema"));
        if (Strings.isNullOrEmpty(schemas))
            throw new RuntimeException("mysql.backupdbs[].schema 为空 示例配置:schema1,schema2 ");
        List<String> schemaList = Lists.newArrayList(schemas.split(","));
        String classDriver = String.valueOf(config.get("classDriver"));
        String ip = String.valueOf(config.get("ip"));
        String port = String.valueOf(config.get("port"));
        String username = String.valueOf(config.get("username"));
        String password = String.valueOf(config.get("password"));
        String url = String.valueOf(config.get("url"));
        if (Strings.isNullOrEmpty(classDriver))
            throw new RuntimeException("mysql.backupdbs[].classDriver 为空");
        if (Strings.isNullOrEmpty(ip))
            throw new RuntimeException("mysql.backupdbs[].ip 为空");
        if (Strings.isNullOrEmpty(port))
            throw new RuntimeException("mysql.backupdbs[].port 为空");
        if (Strings.isNullOrEmpty(username))
            throw new RuntimeException("mysql.backupdbs[].username 为空");
        if (Strings.isNullOrEmpty(password))
            throw new RuntimeException("mysql.backupdbs[].password 为空");
        if (Strings.isNullOrEmpty(url))
            throw new RuntimeException("mysql.backupdbs[].url 为空");
        for (String schema: schemaList) {
            JdbcConnection conn = new JdbcConnection();
            conn.classDriver = classDriver;
            conn.ip = ip;
            conn.port = port;
            conn.schema = schema;
            conn.username = username;
            conn.password = password;
            conn.url = url;
            list.add(conn);
        }
        return list;
    }

    public static JdbcConnection buildMonitir(Map<String,Object> config) {
        if (config== null)
            throw new RuntimeException("mysql.monitordb节点为空");
        String classDriver = String.valueOf(config.get("classDriver"));
        String username = String.valueOf(config.get("username"));
        String password = String.valueOf(config.get("password"));
        String url = String.valueOf(config.get("url"));
        if (Strings.isNullOrEmpty(classDriver))
            throw new RuntimeException("mysql.monitordb.classDriver 为空");
        if (Strings.isNullOrEmpty(username))
            throw new RuntimeException("mysql.monitordb.username 为空");
        if (Strings.isNullOrEmpty(password))
            throw new RuntimeException("mysql.monitordb.password 为空");
        if (Strings.isNullOrEmpty(url))
            throw new RuntimeException("mysql.monitordb.url 为空");
        JdbcConnection conn = new JdbcConnection();
        conn.classDriver = classDriver;
        conn.username = username;
        conn.password = password;
        conn.url = url;
        return conn;
    }

    public static JdbcConnection buildGP(Map<String,Object> config) {
        if (config== null)
            throw new RuntimeException("greenplum 节点为空");
        String classDriver = String.valueOf(config.get("classDriver"));
        String username = String.valueOf(config.get("username"));
        String password = String.valueOf(config.get("password"));
        String url = String.valueOf(config.get("url"));
        if (Strings.isNullOrEmpty(classDriver))
            throw new RuntimeException("mysql.greenplum.classDriver 为空");
        if (Strings.isNullOrEmpty(username))
            throw new RuntimeException("mysql.greenplum.username 为空");
        if (Strings.isNullOrEmpty(password))
            throw new RuntimeException("mysql.greenplum.password 为空");
        if (Strings.isNullOrEmpty(url))
            throw new RuntimeException("mysql.greenplum.url 为空");
        JdbcConnection conn = new JdbcConnection();
        conn.classDriver = classDriver;
        conn.username = username;
        conn.password = password;
        conn.url = url;
        return conn;
    }


    public Connection getConne() {
        if (conn== null) {
            try {
                // 装载驱动包类
                Class.forName(classDriver);
                // 加载驱动
                conn = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                System.out.println("装载驱动包出现异常!请查正！");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("链接数据库发生异常!");
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void close() {
        if (conn!=null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void close(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            try {
                conn.close();
                if ( conn != null) conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

}
