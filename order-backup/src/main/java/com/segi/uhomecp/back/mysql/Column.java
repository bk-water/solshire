package com.segi.uhomecp.back.mysql;


/**
 * 列信息实体
 */
public class Column {
	
	/**
	 * 数据库中列名称
	 */
	private String columnName;
	
	/**
	 * 列数据类型
	 */
	private int columnType;
	
	/**
	 * 列注释
	 */
	private String columnComment;
	
	/**
	 * 是否主键
	 */
	private boolean isPrimary = false;
	/**
	 * 是否自动递增
	 */
	private boolean isAutoIncrement = false;
	/**
	 * 是否允许空
	 */
	private boolean isNullAble=false;

	/**
	 * 是否是外键
	 */
	private boolean isForeignKey=false;

	public boolean isForeignKey() {
		return isForeignKey;
	}

	public void setForeignKey(boolean isForeignKey) {
		this.isForeignKey = isForeignKey;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getColumnType() {
		return columnType;
	}

	public void setColumnType(int columnType) {
		this.columnType = columnType;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public boolean isAutoIncrement() {
		return isAutoIncrement;
	}

	public void setAutoIncrement(boolean isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}

	public boolean isNullAble() {
		return isNullAble;
	}

	public void setNullAble(boolean isNullAble) {
		this.isNullAble = isNullAble;
	}
	
}
