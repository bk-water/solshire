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
public class AdviserOrderIncome extends OrderProductEntity {

    @ApiModelProperty("首年业绩佣金")
    private Float firstIncome;

    @ApiModelProperty("次年业绩佣金")
    private Float secondIncome;

    @ApiModelProperty("首年直属佣金")
    private Float firstDirectlyIncome;

    @ApiModelProperty("次年直属佣金")
    private Float secondDirectlyIncome;

    @ApiModelProperty("首年管理佣金")
    private Float firstManageIncome;

    @ApiModelProperty("次年管理佣金")
    private Float secondManagerIncome;

    @ApiModelProperty("首年渠道佣金")
    private Float firstChannelIncome;

    @ApiModelProperty("次年渠道佣金")
    private Float secondChannelIncome;

    @ApiModelProperty("首年总佣金")
    private Float firstTotalIncome;

    @ApiModelProperty("次年总佣金")
    private Float secondTotalIncome;

    @ApiModelProperty("首年产品费率")
    private String firstRate;

    @ApiModelProperty("次年产品费率")
    private String secondRate;





















}
