package com.solshire.controller;

import com.solshire.model.domain.UserAdmin;
import com.solshire.util.Result;
import com.solshire.util.ResultBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author koabs
 * @Date 2018/5/29.
 * @Describe
 * 用户登入和权限控制
 */
@RestController
@Api(tags = "Admin")
@RequestMapping("/admin")
public class AdminController {

    // 用户列表
    @ApiOperation("登入用户登入")
    @PostMapping("list")
    public ResultBase<List> login(String userName, String password) {
        List<UserAdmin> list = new ArrayList<>();
        return ResultBase.success(list,new UserAdmin());
    }

    // 新增编辑用户

    // 权限列表

    // 角色列表

    // 查看角色拥有的权限

    // 用户拥有的目录树


}
