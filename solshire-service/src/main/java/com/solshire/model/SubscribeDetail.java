package com.solshire.model;

import com.solshire.model.domain.SubscribeBeneficiarie;
import com.solshire.model.domain.SubscribeInsurant;
import com.solshire.model.domain.SubscribeOwner;
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
public class SubscribeDetail {

    @ApiModelProperty("投保人")
    private SubscribeOwner holder;

    @ApiModelProperty("被保人")
    private SubscribeInsurant recognizee;

    @ApiModelProperty("受益人列表")
    List<SubscribeBeneficiarie> beneficiaries;

}
