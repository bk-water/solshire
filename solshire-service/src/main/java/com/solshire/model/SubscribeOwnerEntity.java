package com.solshire.model;

import com.solshire.model.domain.SubscribeOwner;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: koabs
 * 2018/7/1.
 */
@Getter
@Setter
public class SubscribeOwnerEntity extends SubscribeOwner {

    @ApiModelProperty("被保险人")
    private String recognizeeName;

}
