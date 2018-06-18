package com.segi.uhomecp.back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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


    public JdbcConnection(String classDriver, String url, String username, String password) {
        super();
        this.classDriver = classDriver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public JdbcConnection(String classDriver, String url, String username, String password, String schema,String ip,String portss) {
        super();
        this.classDriver = classDriver;
        this.url = url;
        this.username = username;
        this.password = password;
        this.schema = schema;
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
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

}
