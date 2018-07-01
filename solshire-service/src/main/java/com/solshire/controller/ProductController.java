package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.solshire.model.*;
import com.solshire.model.domain.Insuranceplan;
import com.solshire.util.Result;
import com.solshire.util.ResultBase;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author koabs
 * @Date 2018/6/25.
 * @Describe
 */
@RestController
@RequestMapping("")
@Slf4j
@Api(tags = "Product")
public class ProductController {
    // 保单预约列表
    @ApiOperation(value = "保单预约列表",notes = "保单预约列表")
    @GetMapping("subscribe/order")
    public ResultPage<SubscribeOwnerEntity> subscribe(SubscribeQuery query) {
        // 调用保单查询接口
        PageInfo<SubscribeOwnerEntity> pageInfo = null;
        return ResultPage.instance(SubscribeOwnerEntity.class).success(pageInfo);
    }


    @ApiOperation(value = "预约详情",notes = "预约详情")
    @GetMapping("subscribe/order/{orderId}")
    public Result<SubscribeDetail> subscribeDetail(@PathVariable("orderId")Integer orderId) {
        // 调用保单查询接口
        SubscribeDetail info = null;
        return Result.instance(SubscribeDetail.class).success(info);
    }

    @ApiOperation(value = "修改预约单状态",notes = "0预约中，1预约成功，2数据异常，3删除")
    @PostMapping("subscribe/state/{state}")
    public ResultBase updateState(@PathVariable("state")Integer state) {

        return ResultBase.instance().success("修改成功");

    }

    //计划书 列表
    @ApiOperation(value = "计划书列表",notes = "计划书列表")
    @GetMapping("/plan")
    public ResultPage<Insuranceplan> planList(PlanQuery query) {
        // 调用保单查询接口
        PageInfo<Insuranceplan> pageInfo = null;
        return ResultPage.instance(Insuranceplan.class).success(pageInfo);
    }

}
