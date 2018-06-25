package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.solshire.model.*;
import com.solshire.model.domain.OrderData;
import com.solshire.service.OrderDataService;
import com.solshire.service.OrderProductService;
import com.solshire.util.Result;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Author: koabs
 * 2018/6/18.
 * 销售管理
 */
@RestController
@RequestMapping("/sales")
@Slf4j
@Api(tags = "Sales")
public class SalesController {

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    OrderDataService orderDataService;

    // 客户 选择保单里面的客户信息  同时日期查询根据保单日期为准
    // 用户列表
    @ApiOperation(value = "客户列表",notes = "客户列表")
    @GetMapping("/list")
    public ResultPage<ConsumerEntity> listConsumer(RichesQuery query) {
        PageInfo<ConsumerEntity> pageInfo =orderProductService.listConsumer(query);
        return ResultPage.instance(ConsumerEntity.class).success(pageInfo);
    }

    @ApiOperation(value = "客户保单号列表",notes = "客户保单号列表")
    @GetMapping("/orderNo/{certifyNo}")
    @ApiParam(name = "certifyNo",value = "用戶身份證號")
    public Result<List> listOrderNo(@PathVariable String certifyNo) {
        OrderData query = new OrderData();
        query.setCertifyno(certifyNo);
        query.setFlag((short) 2);
        List<OrderData> orderDatas = orderDataService.select(query);
        List<String> list = Lists.transform(orderDatas, new Function<OrderData, String>() {
            @Nullable
            @Override
            public String apply(@Nullable OrderData orderData) {
                return orderData.getPolicyno();
            }
        });
        return Result.instance(List.class).success(list);
    }

    // 保单列表
    @ApiOperation(value = "保单列表",notes = "保单列表")
    @GetMapping("/listOrder")
    public ResultPage<OrderProductEntity> listOrder(ProductQuery query) {
        PageInfo<OrderProductEntity> pageInfo = orderProductService.queryPage(query);
        return ResultPage.instance(OrderProductEntity.class).success(pageInfo);
    }

    // 保单详情
    @ApiOperation(value = "保单详情",notes = "保单详情")
    @GetMapping("/order/{policyNo}")
    public Result<OrderProductDetailEntity> orderDetail(@PathVariable String policyNo) {
        OrderProductDetailEntity orderProductDetailEntity = orderProductService.queryDetailInfoByPolicyNo(policyNo);
        return Result.instance(OrderProductDetailEntity.class).success(orderProductDetailEntity);
    }

}
