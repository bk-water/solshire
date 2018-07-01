package com.solshire.model;

import com.solshire.model.domain.OrderProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Author: koabs
 * 2018/6/26.
 * 产品佣金
 */
@Getter
@Setter
public class ProductOrderIncomeDetail extends OrderProductEntity {
    /**
     * 产品佣金率:feeList[0] 年供奖赏 feeList[1] 首年基率 feeList[2] 次年几率 feeList[3] 第3年 ....
     */
    @ApiModelProperty("产品佣金率:feeList[0] 年供奖赏 feeList[1] 首年基率 feeList[2] 次年几率 feeList[3] 第3年 ...")
    List<String> feeList;

    @ApiModelProperty("应收佣金列表")
    List<String> receivableIncomeList;

    @ApiModelProperty("实收佣金列表")
    List<String> realIncomeList;


}
