package com.solshire.service.impl;

import com.solshire.service.GeneralService;
import com.solshire.util.upload.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: koabs
 * 2018/6/18.
 */
@Service
@Slf4j
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    TempUploadFile tempUploadFile;

    @Autowired
    UEditorUploadFile uEditorUploadFile;

    @Value("${upload.url}")
    public String url;

    @Override
    public UEditorResult uploadUeditorImage(MultipartFile img) {
        return uploadImage(uEditorUploadFile,img);
    }

    @Override
    public UEditorResult uploadTempImage(MultipartFile img) {
        return uploadImage(tempUploadFile,img);
    }

    private UEditorResult uploadImage(AbstractUploadFile uploadInst, MultipartFile img) {
        if(checkImgSize(img))  {
            return  UEditorResult.error("上传的图片大小不能超过2M");
        }
        try {
            FileBo fileBo = uploadInst.uploadFile(img.getOriginalFilename(), img.getInputStream());
//            BufferedImage sourceImg = ImageIO.read(new FileInputStream(fileBo.getFile()));
            return UEditorResult.success(img.getOriginalFilename(),img.getOriginalFilename(),url, fileBo.getRelativePath());
        } catch (Exception e) {
            log.error(e.getMessage());
            return UEditorResult.error("图片上传失败");
        }
    }

    private boolean checkImgSize(MultipartFile img) {
        return (img.getSize()/(1024*1024) >= 2);
    }
}
