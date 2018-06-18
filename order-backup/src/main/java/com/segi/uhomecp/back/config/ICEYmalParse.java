package com.segi.uhomecp.back.config;

import com.google.common.base.Strings;
import com.google.common.io.Resources;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author koabs
 * @Date 2017/12/7.
 * @Describe
 * 解析http2ice 配置文件
 */
public class ICEYmalParse {

    public static String packageStr;

    public static String baseUrl;

    public static Map<String,String> parse(String ymalPath) throws IOException {
        Map<String,String> urlMap = new HashMap<>();
        List<Map> interfaces;
        List<Map> unusualPath;
        Yaml yaml = new Yaml();
        Map<String, Object> ymalMap = null;
        InputStream is = Resources.getResource(ymalPath).openStream();
        if (is != null) {
            ymalMap = (Map<String, Object>) yaml.load(is);
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException("http2ice.yml 配置文件加载出错");
            }
        } else {
            throw new RuntimeException("http2ice.yml 配置文件不存在.");
        }
        packageStr = (String) ymalMap.get("package");
        interfaces = (List<Map>)ymalMap.get("interfaces");
        unusualPath = (List<Map>)ymalMap.get("unusualPath");
        if (Strings.isNullOrEmpty(packageStr))
            throw new RuntimeException("http2ice.yml 文件：package 属性必填");

        if (interfaces!= null) {
            if ( interfaces.size()==0)
                throw new RuntimeException("http2ice.yml 文件：interfaces list 值不能为空.");

            for (Map clazz: interfaces) {
                String name = (String) clazz.get("name");
                String path = (String) clazz.get("path");
                urlMap.put(packageStr+"."+name,path);
                List<Map> methods = (List<Map>)ymalMap.get("method");
                if (methods!=null) {
                    for (Map method: methods) {
                        // 空值判断设置默认值.
                        String mName = (String) clazz.get("name");
                        String mPath = (String) clazz.get("path");
                        urlMap.put(packageStr+"."+name+"."+mName,path+"/"+mPath);
                    }
                }
            }
        }

        if (unusualPath!= null) {
            for (Map clazz: unusualPath) {
                String name = (String) clazz.get("name");
                String path = (String) clazz.get("path");
                urlMap.put(packageStr+"."+name,path);
            }
        }

        return urlMap;
    }
}
