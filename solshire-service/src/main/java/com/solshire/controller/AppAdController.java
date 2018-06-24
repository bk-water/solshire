package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.solshire.model.PageQuery;
import com.solshire.model.domain.ShowData;
import com.solshire.service.ShowDataService;
import com.solshire.util.Result;
import com.solshire.util.ResultBase;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: koabs
 * 2018/6/18.
 * 小程序 展示页面管理
 */
@RestController
@Api(tags = "APPAd")
@RequestMapping("/")
public class AppAdController {

    @Autowired
    ShowDataService showDataService;

    @ApiOperation("APP页面列表")
    @GetMapping("appShowInfo")
    public ResultPage<ShowData> list(PageQuery query) {
        PageInfo<ShowData> pageInfo =showDataService.selectPageAndCount(null,query.getPageNum(),query.getPageSize());
        return ResultPage.instance(ShowData.class).success(pageInfo);
    }

    @ApiOperation("查询页面详情")
    @GetMapping("appShowInfo/{id}")
    public Result<ShowData> queryById(@PathVariable Integer id) {
        ShowData info = showDataService.selectByPk(id);
        return Result.instance(ShowData.class).success(info);
    }

    @ApiOperation("删除页面")
    @DeleteMapping("appShowInfo/{id}")
    public ResultBase deleteById(@PathVariable Integer id) {
        showDataService.deleteByPk(id);
        return ResultBase.instance().success();
    }

    @ApiOperation("保存页面信息(不带id插入)")
    @PostMapping("appShowInfo")
    public Result save(@RequestBody ShowData info) {
        // insert or update 并处理图片路径
        showDataService.save(info);
        return Result.instance(ShowData.class).success(info);
    }

}
