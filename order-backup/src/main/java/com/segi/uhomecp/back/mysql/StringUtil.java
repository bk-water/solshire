package com.segi.uhomecp.back.mysql;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

	public static String getColumnType(int databaseType) {
		String colType = "varchar(256)";
		
//		switch (databaseType) {
//		case Types.DECIMAL:
//			colType = "decimal";
//		case Types.REAL:
//			colType = "Float";
//			break;
//
//		case Types.INTEGER:
//		case Types.BIGINT:
//		case Types.TINYINT:
//
//			colType = "Integer";
//			break;
//		case Types.VARCHAR:
//		case Types.CHAR:
//		case Types.LONGVARBINARY:
//		case Types.LONGVARCHAR:
//			colType = "String";
//			break;
//
//		case Types.DATE:
//		case Types.TIMESTAMP:
//			colType="Date";
//			break;
//		case Types.BIT:
//			colType="Boolean";
//			break;
//		default:
//			System.out.println("找不到数据类型："+databaseType);
//			break;
//		}

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
