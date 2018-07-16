package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.solshire.model.LoginLogEntity;
import com.solshire.model.LoginLogQuery;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.LoginLog;
import com.solshire.model.domain.Riches;
import com.solshire.service.LoginLogService;
import com.solshire.service.RichesService;
import com.solshire.util.Result;
import com.solshire.util.ResultBase;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: koabs
 * 2018/6/6.
 * 用户管理和财富团队
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "Riches")
public class RichesController {

    @Autowired
    RichesService richesService;

    @Autowired
    LoginLogService loginLogService;

    // 用户列表
    @ApiOperation(value = "事业合伙人",notes = "事业合伙人列表")
    @GetMapping("/listPartner")
    public ResultPage<RichesEntity> listPartner(RichesQuery query) {
        // master 1 flag 1
        query.setMaster(1);
        PageInfo<RichesEntity> list =richesService.queryByPage(query);
        return ResultPage.instance(RichesEntity.class).success(list);
    }

    @ApiOperation(value = "顾问",notes = "顾问列表")
    @GetMapping("/listAdviser")
    public ResultPage<RichesEntity> listAdviser(RichesQuery query) {
        // master 0 flag 1
        query.setMaster(0);
        query.setFlags("2,3,6,7");
        PageInfo<RichesEntity> list =richesService.queryByPage(query);
        return ResultPage.instance(RichesEntity.class).success(list);
    }

    @ApiOperation(value = "用户查询",notes = "用户列表")
    @GetMapping("/listUser")
    public ResultPage<RichesEntity> listUser(RichesQuery query) {
        // flag bit0注册用户，bit1财富成员
        query.setFlags("2,3,4,5,6,7");
        PageInfo<RichesEntity> list =richesService.queryByPage(query);
        return ResultPage.instance(RichesEntity.class).success(list);
    }

    // 编辑save
    @ApiOperation("创建修改事业合伙人信息")
    @PostMapping("/partner")
    public Result<RichesEntity> savePartner(@RequestBody RichesEntity user) {
        user.setMaster(1);
        richesService.save(user);
        return Result.instance(RichesEntity.class).success(new RichesEntity());
    }

    @ApiOperation("修改顾问信息")
    @PostMapping("/adviser")
    public Result<RichesEntity> updateAdviser(@RequestBody RichesEntity user) {
        user.setMaster(0);
        richesService.save(user);
        return Result.instance(RichesEntity.class).success(new RichesEntity());
    }

    @ApiOperation("修改用户查询用户信息")
    @PostMapping("")
    public Result<RichesEntity> updateUser(@RequestBody RichesEntity user) {
        user.setMaster(0);
        richesService.save(user);
        return Result.instance(RichesEntity.class).success(user);
    }


    //
    @ApiOperation(value = "用户状态变更",notes = "状态：0正在审核，1正常，2已解约 3 删除")
    @PostMapping("/status")
    public ResultBase status(Integer richeid, Short status) {
        // master 1 flag 1
        Riches riches = new Riches();
        riches.setRicheid(richeid);
        riches.setState(status);
        // 变更前需检查之前状态
        richesService.update(riches);
        return ResultBase.instance().success("变更成功");
    }

    @ApiOperation("用户详情查询")
    @GetMapping("/{id}")
    public Result<RichesEntity> queryById(@PathVariable Integer id) {
        RichesEntity info = richesService.queryById(id);
        return Result.instance(RichesEntity.class).success(info);
    }


    // 下级关系图
    @ApiOperation(value = "下级关系树",notes = "下级关系树")
    @GetMapping("/tree/{id}")
    public Result<List<RichesEntity>> getChild(@PathVariable Integer id) {
        List<RichesEntity> list =richesService.queryChildren(id);
        return Result.instance(List.class).success(list);
    }

    // 直属成员列表
    // 用户列表
    @ApiOperation(value = "直属成员",notes = "直属成员")
    @GetMapping("/directUser")
    public ResultPage<RichesEntity> directUser(RichesQuery query) {
        PageInfo<RichesEntity> list =richesService.queryChildrenByPage(query);
        return ResultPage.instance(RichesEntity.class).success(list);
    }

    // 小程序登入信息
    @ApiOperation(value = "小程序登入记录",notes = "小程序登入记录")
    @GetMapping("/appLoginInfo")
    public ResultPage<LoginLogEntity> directUser(LoginLogQuery query) {
        PageInfo<LoginLogEntity> pageInfo = loginLogService.queryByPage(query);
        return ResultPage.instance(LoginLogEntity.class).success(pageInfo);
    }

    /**
     * 金牌顾问管理
     */

    // TODO: 导出功能
}
