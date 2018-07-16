package com.segi.uhomecp.back.config;

import com.google.common.base.Strings;

import java.util.Map;

/**
 * @Author koabs
 * @Date 2018/7/10.
 * @Describe
 */
public class GPConfig {

    private String delimiter;

    private String gpfdistUrl;

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getGpfdistUrl() {
        return gpfdistUrl;
    }

    public void setGpfdistUrl(String gpfdistUrl) {
        this.gpfdistUrl = gpfdistUrl;
    }

    public static GPConfig build(Map<String, Object> config){
        GPConfig gpConfig = new GPConfig();
        gpConfig.gpfdistUrl = String.valueOf(config.get("gpfdistUrl"));
        gpConfig.delimiter = String.valueOf(config.get("delimiter"));
        if (Strings.isNullOrEmpty(gpConfig.gpfdistUrl))
            throw new RuntimeException("greenplum.gpfdistUrl 未配置");
        if (Strings.isNullOrEmpty(gpConfig.delimiter))
            throw new RuntimeException("greenplum.delimiter 未配置");
        return gpConfig;
    }
}
