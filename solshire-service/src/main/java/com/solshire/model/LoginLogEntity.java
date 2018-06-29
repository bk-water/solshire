package com.solshire.model;

import com.solshire.model.domain.LoginLog;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: koabs
 * 2018/6/18.
 */
@Getter
@Setter
public class LoginLogEntity extends LoginLog {

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("用户名")
    private String userName;

}
