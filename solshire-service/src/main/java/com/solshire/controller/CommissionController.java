package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.solshire.model.*;
import com.solshire.util.Result;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author koabs
 * @Date 2018/6/25.
 * @Describe
 * 佣金管理
 */
@RestController
@RequestMapping("/commission")
@Slf4j
@Api(tags = "Commission")
public class CommissionController {


    // 业绩酬金
// 客户 选择保单里面的客户信息  同时日期查询根据保单日期为准
    // 用户列表
    @ApiOperation(value = "业绩酬金",notes = "业绩酬金")
    @GetMapping("/adviser")
    public ResultPage<AdviserOrderIncome> adviser(ProductQuery query) {
        // 调用保单查询接口
        PageInfo<AdviserOrderIncome> pageInfo = null;
        return ResultPage.instance(AdviserOrderIncome.class).success(pageInfo);
    }


    @ApiOperation(value = "业绩酬金详情",notes = "业绩酬金详情")
    @GetMapping("/adviser/{policyNo}")
    public Result<AdviserOrderIncome> adviserDetail(ProductQuery query) {
        // 调用保单查询接口
        AdviserOrderIncome info = null;
        return Result.instance(AdviserOrderIncome.class).success(info);
    }


    @ApiOperation(value = "产品佣金",notes = "产品佣金")
    @GetMapping("/product")
    public ResultPage<ProductIncome> product(ProductQuery query) {
        // 调用保单查询接口
        PageInfo<ProductIncome> pageInfo = null;
        return ResultPage.instance(ProductIncome.class).success(pageInfo);
    }

    @ApiOperation(value = "产品佣金详情",notes = "业绩酬金详情")
    @GetMapping("/product/{policyNo}")
    public Result<ProductIncome> productDetail(ProductQuery query) {
        // 调用保单查询接口
        ProductIncome info = null;
        return Result.instance(ProductIncome.class).success(info);
    }

    //
    // 产品佣金详情

    // 酬金发放
    // 详情
    // 审核
    // 支付
    // 酬金日志
    // 酬金异常

}
