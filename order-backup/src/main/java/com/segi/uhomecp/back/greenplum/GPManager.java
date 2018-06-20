package com.segi.uhomecp.back.greenplum;

import com.segi.uhomecp.back.JdbcConnection;
import com.segi.uhomecp.back.mysql.Column;
import com.segi.uhomecp.back.mysql.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author koabs
 * @Date 2018/6/13.
 * @Describe
 * 管理gp 链接
 */
public class GPManager {

    public JdbcConnection jdbcConn;

    private GPManager() {}

    private static GPManager instance = null;

    public static GPManager instance(JdbcConnection jdbcConnection) {
        if (instance == null) {
            instance = new GPManager();
            instance.jdbcConn = jdbcConnection;
        }
        return instance;
    }

    /**
     * 创建外部表
     * @param createTableSql
     * @param tableName
     * @throws SQLException
     */
    public void createExternalTable(String createTableSql,String tableName) throws SQLException {
        String dropExtTableSql = "DROP EXTERNAL TABLE IF EXISTS " + tableName +"_ext";
        Statement statement =  jdbcConn.getConne().createStatement();
        statement.execute(dropExtTableSql);
        statement.execute(createTableSql);
        statement.close();
    }

    /**
     * 1. 先删除已经导入的数据
     * 2. 导入数据
     * 3.返回导入的数据条数
     * @param table
     * @param backNum
     */
    public Integer importDateFromExtTable(Table table, String backNum) throws SQLException {
        String deleteDataSql = "delete from  " + table.getTableName() +"where backNum = '"+backNum+"'";
        StringBuffer columsStr = new StringBuffer();
        for (Column column: table.getColumnList()) {
            columsStr.append(column.getColumnName()).append(",");
        }
        String insertIntoSql = "INSERT INTO " + table.getTableName()+" SELECT "+ columsStr.toString() +
               ", '"+ backNum +"' as backNum"+ " FROM user_permission_ext;";
        String countSql = "select count(*) from " + table.getTableName();
        Statement statement =  jdbcConn.getConne().createStatement();
        statement.execute(deleteDataSql);
        statement.execute(insertIntoSql);
        ResultSet resultSet = statement.executeQuery(countSql);
        Integer total = 0;
        while (resultSet.next()) {
            //取出列值
            total = resultSet.getInt(1);
        }
        statement.close();
        return total;
    }


}
