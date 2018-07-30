package com.segi.uhomecp.back.mysql;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Types;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 字符串处理工具类
 * 
 * @ClassName: StringUtil
 * @author Andrew.Wen
 * @date 2013-1-10 下午3:36:22
 */
public class StringUtil {

	/**
	 * 获得类首字母小写
	 * 
	 * @param className
	 * @return
	 */
	public static String getClassLower(String className) {
		return className.substring(0, 1).toLowerCase() + className.substring(1);
	}

	/**
	 * 获得类首字母大写
	 * 
	 * @param className
	 * @return
	 */
	public static String getClassUpper(String className) {
		return className.substring(0, 1).toUpperCase() + className.substring(1);
	}

	/**
	 * 获得set 方法
	 * 
	 * @Title: getSetMethod
	 * @param field
	 *            字段名称
	 * @return
	 */
	public static String getSetMethod(String field) {
		String methodStr = "";

		methodStr = "set";

		if ((field == null) || (field == "")) {
			return "";
		} else {
			field = methodStr + field.substring(0, 1).toUpperCase()
					+ field.substring(1);

			return field;
		}
	}

	/**
	 * 获得get 方法
	 * 
	 * @Title: getGetMethod
	 * @param field
	 *            字段名称
	 * @return
	 */
	public static String getGetMethod(String field) {
		String methodStr = "";

		methodStr = "get";

		if ((field == null) || (field == "")) {
			return "";
		} else {
			field = methodStr + field.substring(0, 1).toUpperCase() + field.substring(1);

			return field;
		}
	}
	
	/**
	 * 去掉下划线，将下划线后首字母大写
	 * 
	 * @Title: getDomainColumnName
	 * @param databaseColumn
	 * @return
	 */
	public static String getDomainColumnName(String databaseColumn) {

		if ((databaseColumn == null) || (databaseColumn == "")) {
			return "";
		} else {

			int _postion = -1;

			while (databaseColumn.indexOf("_") > 0) {
				_postion = databaseColumn.indexOf("_");
				if (_postion < databaseColumn.length() - 1) {
					databaseColumn = databaseColumn.substring(0, _postion)
							+ databaseColumn.substring(_postion + 1,
									_postion + 2).toUpperCase()
							+ databaseColumn.substring(_postion + 2,
									databaseColumn.length());
				} else {
					databaseColumn = databaseColumn.replace("_", "");
				}
			}

		}

		return databaseColumn;

	}

	public static String getColumnType(String databaseType) {
		String colType;
		switch (databaseType) {
			case "enum":
				colType = "enum";
				break;
			case "tinyint":
				colType = "smallint";
				break;
			case "mediumint":
				colType = "integer";
				break;
			case "tinyint unsigned":
				colType = "smallint";
				break;
			case "mediumint unsigned":
				colType = "integer";
				break;
			case "int unsigned":
				colType = "bigint";
				break;
			case "bigint unsigned":
				colType = "numeric(20)";
				break;
			case "double":
				colType = "double precision";
				break;
			case "float":
				colType = "real";
				break;
			case "datetime":
				colType = "timestamp";
				break;
			case "longtext":
				colType = "text";
				break;
			case "mediumtext":
				colType = "text";
				break;
			case "blob":
				colType = "bytea";
				break;
			case "mediumblob":
				colType = "bytea";
				break;
		default:
			colType = databaseType;
			break;
		}
		return colType;
	}

	/**
	 * 从属性文件获取配置
	 * @param filename
	 * @param key
	 * @return
	 * @throws FileNotFoundException 
	 */
	public synchronized static String getPropertyFromFile(String filename, String key) 
    {

		String paodingAnalysisPath = System.getProperty("user.dir") + "\\"+filename;
		
		InputStream in1=null;
		ResourceBundle rb=null;
		try {
			in1 = new BufferedInputStream(new FileInputStream(paodingAnalysisPath));
			
			   rb = new PropertyResourceBundle(in1);
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ResourceBundle resourceBundle1 = new PropertyResourceBundle(in1);
		
		
     

        return rb.getString(key).trim();

    }
}
