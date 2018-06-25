package com.solshire.util.upload;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class FileBo {
    private File file;
    private String name;
    private String path;
    private String ext;
    private String url;
    private String relativePath;

    public FileBo(File file, String name, String url, String path, String ext, String relativePath) {
        this.file = file;
        this.name = name;
        this.path = path;
        this.ext = ext;
        this.url = url;
        this.relativePath = relativePath;
    }
}
