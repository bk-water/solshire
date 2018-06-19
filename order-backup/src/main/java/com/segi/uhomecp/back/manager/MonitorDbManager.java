package com.segi.uhomecp.back.manager;

import com.segi.uhomecp.back.JdbcConnection;
import com.segi.uhomecp.back.greenplum.GPManager;

/**
 * @Author koabs
 * @Date 2018/6/19.
 * @Describe
 */
public class MonitorDbManager {

    public JdbcConnection jdbcConn;

    private MonitorDbManager() {}

    private static MonitorDbManager instance = null;

    public static MonitorDbManager instance(JdbcConnection conn) {
        if (instance==null) {
            MonitorDbManager monitorDbManager = new MonitorDbManager();
            monitorDbManager.jdbcConn =conn;
        }
        return instance;
    }



}
