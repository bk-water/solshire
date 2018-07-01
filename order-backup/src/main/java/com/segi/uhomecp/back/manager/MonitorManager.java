package com.segi.uhomecp.back.manager;

import com.segi.uhomecp.back.JdbcConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author koabs
 * @Date 2018/6/19.
 * @Describe
 * 监控日志
 */
public class MonitorManager {

    public JdbcConnection jdbcConn;
    public String month;

    public List<String> logs = new ArrayList<>();

    private MonitorManager() {}

    private static MonitorManager instance = null;

    public static MonitorManager instance(JdbcConnection conn,String month) {
        if (instance==null) {
            MonitorManager monitorDbManager = new MonitorManager();
            monitorDbManager.jdbcConn =conn;
            monitorDbManager.month = month;
        }
        return instance;
    }

    public void info(String title,String content, String db, String table) throws SQLException {
        MonitorEntity info = new MonitorEntity(title,content,"info",this.month,db,table,new Date());
        insertLog(info);
        this.logs.add(info.toString());
    }

    public void error(String title,String content, String db, String table) throws SQLException {
        MonitorEntity info = new MonitorEntity(title,content,"error",this.month,db,table,new Date());
        insertLog(info);
        this.logs.add(info.toString());
    }

    private void insertLog(MonitorEntity info) throws SQLException {
        String insertIntoSql = "INSERT INTO `user_permission`(`title`,`content`,`level`,`month`,`db`,`table`,`createDate`)" +
                " VALUES('"+info.title+"','"+info.content+"','"+info.level+"','"+info.month+"','"+info.db+"','"+info.table+"',now());";
        Statement statement =  jdbcConn.getConne().createStatement();
        statement.execute(insertIntoSql);
        statement.close();
    }

    class MonitorEntity {
        public String title;
        public String content;
        public String level;
        public String month;
        public String db;
        public String table;
        public Date createDate;

        public MonitorEntity(String title, String content, String level, String month, String db, String table, Date createDate) {
            this.title = title;
            this.content = content;
            this.level = level;
            this.month = month;
            this.db = db;
            this.table = table;
            this.createDate = createDate;
        }

        @Override
        public String toString() {
            return "MonitorEntity{" +
                    "title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", level='" + level + '\'' +
                    ", month='" + month + '\'' +
                    ", db='" + db + '\'' +
                    ", table='" + table + '\'' +
                    ", createDate=" + createDate +
                    '}';
        }
    }

}
