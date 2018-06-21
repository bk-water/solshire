package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.solshire.model.*;
import com.solshire.util.Result;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    // 客户 选择保单里面的客户信息  同时日期查询根据保单日期为准
    // 用户列表
    @ApiOperation(value = "客户列表",notes = "客户列表")
    @GetMapping("")
    public ResultPage<ConsumerEntity> listConsumer(RichesQuery query) {
        PageInfo<ConsumerEntity> pageInfo = new PageInfo<>();
        return ResultPage.instance(ConsumerEntity.class).success(pageInfo);
    }

    @ApiOperation(value = "客户保单号列表",notes = "客户保单号列表")
    @GetMapping("/orderNo/${consumerId}")
    public Result<String> listOrderNo(@PathVariable String consumerId) {
       List<String> list = new ArrayList<>();
       return Result.instance(List.class).success(list);
    }

    // 保单列表
    @ApiOperation(value = "保单列表",notes = "保单列表")
    @GetMapping("/listOrder")
    public ResultPage<OrderProductEntity> listOrder(RichesQuery query) {
        PageInfo<OrderProductEntity> pageInfo = new PageInfo<>();
        return ResultPage.instance(OrderProductEntity.class).success(pageInfo);
    }

    // 保单详情
    @ApiOperation(value = "保单详情",notes = "保单详情")
    @GetMapping("/order/${orderNo}")
    public Result<OrderEntity> orderDetail(@PathVariable String orderNo) {
        OrderEntity orderEntity = new OrderEntity();
        return Result.instance(OrderEntity.class).success(orderEntity);
    }

}
