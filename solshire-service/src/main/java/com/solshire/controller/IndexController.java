package com.solshire.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.solshire.util.ResultBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @Author koabs
 * @Date 2018/5/29.
 * @Describe
 */
@RestController
@RequestMapping("/")
@Slf4j
@Api(tags = "Admin")
public class IndexController {

    // 验证码
    @Autowired
    private Producer captchaProducer = null;

    @ApiOperation("登入用户登入")
    @PostMapping("login")
    public ResultBase login(String userName, String password) {
        return ResultBase.instance().success();
    }

    @ApiOperation("用户登出")
    @PostMapping("loginOut")
    public ResultBase loginOut() {
        return ResultBase.instance().success();
    }

    // 找回密码

    @ApiOperation("验证码")
    @RequestMapping("/kaptcha/*")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("******************生成后验证码是: " + code + "******************");
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
