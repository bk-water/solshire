package com.segi.uhomecp.back.mysql;

//import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 表实体
 */
public class Table {

	/**
	 * 数据库
	 */
	private String tableSchem;

	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 表注释
	 */
	private String tableComment;

	/**
	 * 列
	 */
	private List<Column> columnList = new ArrayList<Column>();

	
	/**
	 * 获得第一个主键
	 * 
	 * @Title: getFirstPrimaryKey
	 * @return
	 */
	public Column getFirstPrimaryKey() {
		
		for (Column tempCul : this.getColumnList()) {
			if (tempCul.isPrimary()) {
				return tempCul;
			}
		}
		return null;

	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}

	public String getTableSchem() {
		return tableSchem;
	}

	public void setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
	}
	
}
