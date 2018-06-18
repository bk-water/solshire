package com.solshire.controller;

import com.solshire.model.domain.ShowData;
import com.solshire.util.Result;
import com.solshire.util.ResultBase;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: koabs
 * 2018/6/18.
 * 小程序 展示页面管理
 */
@RestController
@Api(tags = "APPAd")
@RequestMapping("/appShowInfo")
public class AppAdController {

    @ApiOperation("APP页面列表")
    @GetMapping("")
    public ResultPage<ShowData> list() {
        List<ShowData> list = new ArrayList<>();

        return ResultPage.instance(ShowData.class).success(list);
    }

    @ApiOperation("查询页面详情")
    @GetMapping("appShowInfo/{id}")
    public Result<ShowData> queryById(@PathVariable Integer id) {
        return Result.instance(ShowData.class).success(new ShowData());
    }

    @ApiOperation("删除页面")
    @DeleteMapping("appShowInfo/{id}")
    public ResultBase deleteById(@PathVariable Integer id) {
        return ResultBase.instance().success();
    }

    @ApiOperation("保存页面信息(不带id插入)")
    @PostMapping("")
    public Result save(@RequestBody ShowData user) {
        // insert or update 并处理图片路径
        return Result.instance(ShowData.class).success(new ShowData());
    }

}
