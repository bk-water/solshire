package com.segi.uhomecp.back.config;

/**
 * Author: koabs
 * 2018/6/15.
 */
public class DumpConfig {

    private String binPath;
    private String month;
    private String exportFolder;

    public DumpConfig(String binPath, String month, String exportFolder) {
        this.binPath = binPath;
        this.month = month;
        this.exportFolder = exportFolder;
    }

    public String getBinPath() {
        return binPath;
    }

    public void setBinPath(String binPath) {
        this.binPath = binPath;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getExportFolder() {
        return exportFolder;
    }

    public void setExportFolder(String exportFolder) {
        this.exportFolder = exportFolder;
    }
}
