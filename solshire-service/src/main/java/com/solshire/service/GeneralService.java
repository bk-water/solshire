package com.solshire.service;

import com.solshire.util.upload.UEditorResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: koabs
 * 2018/6/18.
 */
public interface GeneralService {

    /**
     * 上传文件
     * @return
     */
    public UEditorResult uploadTempImage(MultipartFile img);

    /**
     * 富文本编辑器上传图片
     * @param img
     * @return
     */
    public UEditorResult uploadUeditorImage(MultipartFile img);
}
