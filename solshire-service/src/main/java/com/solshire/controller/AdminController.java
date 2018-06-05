package com.solshire.controller;

import com.solshire.model.domain.UserAdmin;
import com.solshire.model.domain.UserPermission;
import com.solshire.model.domain.UserRole;
import com.solshire.util.Result;
import com.solshire.util.ResultBase;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/")
public class AdminController {

    // 用户列表
    @ApiOperation("用户列表")
    @GetMapping("admin")
    public ResultPage<UserAdmin> list(String userName) {
        List<UserAdmin> list = new ArrayList<>();

        return ResultPage.instance(UserAdmin.class).success(list);
    }

    @ApiOperation("查询用户")
    @GetMapping("admin/{id}")
    public Result<UserAdmin> queryById(@PathVariable Integer id) {
        return Result.instance(UserAdmin.class).success(new UserAdmin());
    }

    // 新增编辑用户
    @ApiOperation("保存用户")
    @PostMapping("admin")
    public Result save(@RequestBody UserAdmin user) {
        return Result.instance(UserAdmin.class).success(new UserAdmin());
    }

    @ApiOperation("删除用户")
    @DeleteMapping("admin/{id}")
    public ResultBase delete(@PathVariable Integer id) {
        return ResultBase.instance().success();
    }

    // 用户拥有的目录树
    @ApiOperation("查询用户菜单树")
    @GetMapping("admin/tree/{id}")
    public ResultPage<UserPermission> queryPermissionsByUser(@PathVariable Integer id) {
        List<UserPermission> list = new ArrayList<>();
        return ResultPage.instance(UserPermission.class).success(list);
    }

    @ApiOperation("给用户赋角色")
    @PostMapping("admin/role/{userId}")
    public ResultPage<UserPermission> saveUserAndRoleRel(@PathVariable Integer userId,String roleId) {
        List<UserPermission> list = new ArrayList<>();
        return ResultPage.instance(UserPermission.class).success(list);
    }


    // 权限列表
    @ApiOperation("基础权限列表")
    @GetMapping("permissions")
    public ResultPage<UserPermission> permissions() {
        List<UserPermission> list = new ArrayList<>();
        return ResultPage.instance(UserPermission.class).success(list);
    }
    // 角色列表
    @ApiOperation("角色列表")
    @GetMapping("roles")
    public ResultPage<UserRole> roles() {
        List<UserRole> list = new ArrayList<>();
        return ResultPage.instance(UserRole.class).success(list);
    }

    // 查看角色拥有的权限
    @ApiOperation("查询角色拥有的权限")
    @GetMapping("roles/permissions/{id}")
    public ResultPage<UserPermission> queryPermissionsByRole(@PathVariable Integer id) {
        List<UserPermission> list = new ArrayList<>();
        return ResultPage.instance(UserPermission.class).success(list);
    }

    // 后台用户登入记录

}
