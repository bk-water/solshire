package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.solshire.model.UserAdminInfo;
import com.solshire.model.UserAdminQuery;
import com.solshire.model.domain.UserAdmin;
import com.solshire.model.domain.UserAdminLoginLog;
import com.solshire.model.domain.UserPermission;
import com.solshire.model.domain.UserRole;
import com.solshire.service.UserAdminService;
import com.solshire.service.UserPermissionService;
import com.solshire.util.Result;
import com.solshire.util.ResultBase;
import com.solshire.util.ResultPage;
import com.solshire.util.tree.TreeBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserPermissionService userPermissionService;

    @Autowired
    UserAdminService userAdminService;


    // 用户列表
    @ApiOperation("用户列表")
    @GetMapping("admin")
    public ResultPage<UserAdmin> list(UserAdminQuery query) {
        PageInfo<UserAdmin> list = userAdminService.selectPageAndCount(null, query.getPageNum(),query.getPageSize());
        return ResultPage.instance(UserAdmin.class).success(list);
    }

    @ApiOperation("查询用户")
    @GetMapping("admin/{id}")
    public Result<UserAdmin> queryById(@PathVariable Long id) {
        UserAdmin info = userAdminService.selectByPk(id);
        return Result.instance(UserAdmin.class).success(info);
    }

    // 新增编辑用户
    @ApiOperation("保存用户")
    @PostMapping("admin")
    public Result save(@RequestBody UserAdmin user) {
        userAdminService.save(user);
        return Result.instance(UserAdmin.class).success(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("admin/{id}")
    public ResultBase delete(@PathVariable Long id) {
        userAdminService.deleteByPk(id);
        return ResultBase.instance().success();
    }

    // 用户拥有的目录树
    @ApiOperation("查询用户菜单树")
    @GetMapping("admin/tree")
    public Result<List> queryPermissionsByUser() {
        // 获取当前登入用户菜单
        List<UserPermission> list = userPermissionService.select(null);
        return Result.instance(List.class).success(TreeBuilder.build(list));
    }

    // 后台用户登入记录
    @ApiOperation("查询后台用户登入记录")
    @GetMapping("admin/loginRecord")
    public ResultPage<UserAdminLoginLog> queryUserAdminLoginLog() {
        // 获取当前登入用户菜单
        List<UserAdminLoginLog> list = new ArrayList<>();
        return ResultPage.instance(UserAdminLoginLog.class).success(list);
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
        // 排序
        List<UserPermission> list = new ArrayList<>();
        return ResultPage.instance(UserPermission.class).success(list);
    }

    @ApiOperation("用户登入首页")
    @GetMapping("admin/index")
    public Result<UserAdminInfo> adminIndex() {
        Long userId = 1L;
        UserAdminInfo info = userAdminService.queryInfoById(userId);
        return Result.instance(UserAdminInfo.class).success(info);
    }

}
