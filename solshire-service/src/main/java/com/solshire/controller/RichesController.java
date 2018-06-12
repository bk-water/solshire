package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.service.RichesService;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: koabs
 * 2018/6/6.
 * 用户管理和财富团队
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "User")
public class RichesController {

    @Autowired
    RichesService richesService;

    // 用户列表
    @ApiOperation(value = "用户列表",notes = "事业合伙人,顾问,用户列表")
    @GetMapping("")
    public ResultPage<RichesEntity> list(RichesQuery query) {
        PageInfo<RichesEntity> list =richesService.queryByPage(query);
        return ResultPage.instance(RichesEntity.class).success(list);
    }

    // 编辑save

    // 下级关系图

    // 直属成员列表


}
