package com.solshire.model;

import com.solshire.model.domain.LoginLog;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: koabs
 * 2018/6/18.
 */
@Getter
@Setter
public class LoginLogEntity extends LoginLog {

    private String userId;

    private String userName;

}
