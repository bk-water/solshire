package com.solshire.model;

import com.solshire.model.domain.OrderProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: koabs
 * 2018/6/26.
 * 顾问保单收益
 */
@Getter
@Setter
public class ProductOrderIncome extends OrderProductEntity {

    @ApiModelProperty("首年应收佣金")
    private Float firstReceivableIncome;

    @ApiModelProperty("首年实收佣金")
    private Float firstRealIncome;

    @ApiModelProperty("次年实收佣金")
    private Float secondRealIncome;

    @ApiModelProperty("次年应收佣金")
    private Float secondReceivableIncome;


    @ApiModelProperty("首年实收总佣金")
    private Float firstRealTotalIncome;

    @ApiModelProperty("次年实收总佣金")
    private Float secondRealTotalIncome;

























}
