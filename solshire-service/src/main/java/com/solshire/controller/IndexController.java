package com.solshire.controller;

import com.solshire.util.ResultBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // 验证码



}
