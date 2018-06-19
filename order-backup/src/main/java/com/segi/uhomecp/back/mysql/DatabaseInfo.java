package com.segi.uhomecp.back.mysql;

import com.google.gson.Gson;
import com.segi.uhomecp.back.JdbcConnection;
import com.segi.uhomecp.back.config.DumpConfig;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库信息获得操作类
 */
public class DatabaseInfo extends Database{

	private JdbcConnection jdbcConn;

	public static DatabaseInfo instance(String classDriver, String url, String username, String password) {
		DatabaseInfo dbinfo = new DatabaseInfo();
		dbinfo.jdbcConn = new JdbcConnection(classDriver,url,username,password);
		return dbinfo;
	}


	/**
	 * 获得表数据
	 * 
	 * @Title: getDbTableInfo
	 * @return
	 * @throws SQLException
	 */
	public Table getDbTableInfo(String tableName) throws SQLException {

		// 初始化数据库
		// 获取数据库信息
		DatabaseMetaData dbmd = jdbcConn.getConne().getMetaData();
		// 获得数据库表
		ResultSet rs = dbmd.getTables(null, null, tableName, new String[] { "TABLE"});

		Table table = new Table();
		while (rs.next()) {
			table.setTableName(rs.getString("TABLE_NAME"));
			table.setTableComment(rs.getString("REMARKS"));
			table.setTableSchem(rs.getString(1));

			// 设置列信息
			ResultSet rscol = dbmd.getColumns(null, null, table.getTableName(), null);

			Column tempColumn;

			while (rscol.next()) {
				tempColumn = new Column();
				tempColumn.setColumnName(rscol.getString("COLUMN_NAME"));
				tempColumn.setColumnType(Integer.parseInt(rscol.getString("DATA_TYPE")));

				String remarks = rscol.getString("REMARKS");
				if (remarks.length() < 1)
					remarks = "";
				tempColumn.setColumnComment(remarks);
				tempColumn.setAutoIncrement(rscol.getString("IS_AUTOINCREMENT").equals("YES"));
				tempColumn.setNullAble(rscol.getString("IS_AUTOINCREMENT").equals("YES"));

				// 添加列到表中
				table.getColumnList().add(tempColumn);

			}

			// 设置主键列
			ResultSet rsPrimary = dbmd.getPrimaryKeys(null, null, table.getTableName());
			while (rsPrimary.next()) {
				if (rsPrimary.getString("COLUMN_NAME") != null) {

					for (int i = 0; i < table.getColumnList().size(); i++) {
						Column coltemp = table.getColumnList().get(i);
						if (coltemp.getColumnName().equals(rsPrimary.getString("COLUMN_NAME"))) {
							coltemp.setPrimary(true);
						}
					}

				}
			}

			// 设置外键列
			ResultSet rsFPrimary = dbmd.getImportedKeys(null, null, table.getTableName());
			while (rsFPrimary.next()) {

				for (int i = 0; i < table.getColumnList().size(); i++) {
					Column coltemp = table.getColumnList().get(i);
					if (coltemp.getColumnName().equals(rsFPrimary.getString("FKCOLUMN_NAME"))) {
						coltemp.setForeignKey(true);
					}
				}
			}

		}
		return table;
	}

	public String getCreateGPExternalTable(String tableName,String delimiter,
										   String gpfdistUrl,String errorTableName) throws SQLException {
		StringBuffer createExternalTable = new StringBuffer("CREATE EXTERNAL TABLE  ");
//				"CREATE EXTERNAL TABLE  user_permission_ext (" +
//				"  id varchar(20)," +
//				"  url varchar(256) ," +
//				"  name varchar(64) ," +
//				"  parentId varchar(20)," +
//				"  code varchar(64)," +
//				"  type varchar(64)" +
//				")"+ "LOCATION ('gpfdist://127.0.0.1:7981/*.txt')" +
//				"FORMAT 'CSV' ( DELIMITER ',' null '\N')" +
//				"LOG ERRORS INTO err_user_permission SEGMENT REJECT LIMIT 5;";
		Table table = getDbTableInfo(tableName);
		createExternalTable.append(table.getTableName()).append("_ext").append("(");
		for (Column column : table.getColumnList()) {
			createExternalTable.append(column.getColumnName()).append(" ")
					.append(StringUtil.getColumnType(column.getColumnType())).append(",");

		}
		createExternalTable.append(")").append("LOCATION ('").append(gpfdistUrl).append("')")
		.append("FORMAT 'CSV' ( DELIMITER '").append(delimiter).append("' null '\\\\N')")
		.append("LOG ERRORS INTO ").append(errorTableName).append(" SEGMENT REJECT LIMIT 5;");


		return createExternalTable.toString().replace(",)",")");
	}


	public void dumpTableDate(DumpConfig dumpConfig,String tableName) throws IOException {
//		MysqlDumpUtil.dumpMysqlData("47.75.10.26","3306","cyd1991","MY78sdQPl11!",
//				"/tmp/mysql-export-csv","201809","solshire","user_permission", "/usr/local/mysql/bin");
		MysqlDumpUtil.dumpMysqlData("47.75.10.26","3306","cyd1991","MY78sdQPl11!",
				"/tmp/mysql-export-csv","201809","solshire","user_permission", "/usr/local/mysql/bin");
	}


	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://47.75.10.26:3306/solshire?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=false";
		String classDriver = "com.mysql.jdbc.Driver";
		String username = "cyd1991";
		String password = "MY78sdQPl11!";
		DatabaseInfo databaseInfo = DatabaseInfo.instance(classDriver,url,username,password);
//		Table table = databaseInfo.getDbTableInfo("user_permission");
//		System.out.printf("Table Info: "+ new Gson().toJson(table));
		databaseInfo.jdbcConn.close();
		System.out.printf(databaseInfo.getCreateGPExternalTable("user_permission",","
				,"gpfdist://127.0.0.1:7981/*.txt","err_user_permission"));
	}

}
