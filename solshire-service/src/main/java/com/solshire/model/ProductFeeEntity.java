package com.solshire.model;

import com.solshire.model.domain.Productfee;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author: koabs
 * 2018/7/1.
 */
@Setter
@Getter
public class ProductFeeEntity extends Productfee {
    /**
     * 产品佣金率: feeList[0] 第3年 ....
     */
    @ApiModelProperty("feeList[0] 第3年 ...")
    List<String> feeList;

}
