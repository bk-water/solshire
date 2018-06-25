package com.solshire.util.upload;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: koabs
 * 7/20/16.
 */
@Getter
@Setter
public class UEditorResult {
    private String name;
    private String originalName;
    private String size;
    private String state; //SUCCESS
    private String type;
    private String url;
    private String msg;
    private String path;


    public static UEditorResult success(String name, String originalName, String url,String path) {
        return new UEditorResult(name, originalName, "10", "SUCCESS", ".jpg",url, path);
    }

    public static UEditorResult error(String msg) {
        return new UEditorResult("ERROR", msg);
    }


    public UEditorResult(String state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public UEditorResult(String name, String originalName, String size, String state, String type, String url,String path) {
        this.name = name;
        this.originalName = originalName;
        this.size = size;
        this.state = state;
        this.type = type;
        this.url = url;
        this.path = path;
    }

}
