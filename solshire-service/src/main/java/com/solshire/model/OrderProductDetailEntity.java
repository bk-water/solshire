package com.solshire.model;

import com.solshire.model.domain.OrderData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: koabs
 * 2018/6/24.
 * 保單詳情
 */

@Getter
@Setter
public class OrderProductDetailEntity {

    /**
     * 保单信息
     */
    @ApiModelProperty("保单信息")
    private OrderProductEntity productInfo;

    /**
     * 顾问信息
     */
    @ApiModelProperty("顾问信息")
    private RichesEntity adviserInfo;

    /**
     * 投保人信息
     */
    @ApiModelProperty("投保人信息")
    private OrderData holderInfo;

    /**
     * 被保人信息
     */
    @ApiModelProperty("被保人信息")
    private OrderData insurantInfo;

}
