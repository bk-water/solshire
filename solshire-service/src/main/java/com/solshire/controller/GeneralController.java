package com.solshire.controller;


import com.solshire.service.GeneralService;
import com.solshire.util.upload.UEditorResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公共URL访问
 * 文件上传等公共方法ßßßß
 */
@RestController
@Api(tags = "Gen")
@RequestMapping(value = "gen")
public class GeneralController {

    @Autowired
    GeneralService generalService;



    /**
     * 上传临时文件
     * @param img
     * @return
     */
    @PostMapping(value = "/upload")
    @ApiOperation("上传临时文件")
    public UEditorResult updateTempFile(@RequestParam(required = false) MultipartFile img) throws Exception{
        return generalService.uploadTempImage(img);
    }



    /**
     * 富文本编辑器上传图片方法
     * @param upfile
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/uploadFile")
    @ApiOperation("富文本编辑器上传图片方法")
    public UEditorResult updateUEditorFile(@RequestParam(required = false) MultipartFile upfile) throws Exception{
        return generalService.uploadUeditorImage(upfile);
    }

}