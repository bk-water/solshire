package com.solshire.controller;

import com.github.pagehelper.PageInfo;
import com.solshire.model.AdviserOrderIncome;
import com.solshire.model.ProductFeeEntity;
import com.solshire.model.ProductQuery;
import com.solshire.model.domain.Productfee;
import com.solshire.util.Result;
import com.solshire.util.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Author: koabs
 * 2018/7/1.
 * 保险产品,财富团队费率
 */
@RestController
@RequestMapping("/fee")
@Slf4j
@Api(tags = "Fee")
public class FeeController {

    @ApiOperation(value = "保险产品费率",notes = "财富团队费率同此接口")
    @GetMapping("/product")
    public ResultPage<Productfee> product(ProductQuery query) {
        // 调用保单查询接口
        PageInfo<Productfee> pageInfo = null;
        return ResultPage.instance(Productfee.class).success(pageInfo);
    }


    @ApiOperation(value = "保险产品费率详情",notes = "财富团队费率同此接口")
    @GetMapping("/product/{feeId}")
    public Result<ProductFeeEntity> productDetail(@PathVariable("feeId")Integer feeId) {
        // 调用保单查询接口
        ProductFeeEntity info = null;
        return Result.instance(ProductFeeEntity.class).success(info);
    }

    @ApiOperation(value = "修改保险产品费率",notes = "财富团队费率同此接口")
    @PostMapping("/product")
    public Result<Productfee> updateProduct(Productfee info) {
        // 调用保单查询接口
        Productfee infos = null;
        return Result.instance(Productfee.class).success(info);
    }

    // TODO: 导入
}
