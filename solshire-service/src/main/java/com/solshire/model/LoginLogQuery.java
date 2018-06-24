package com.solshire.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author koabs
 * @Date 2018/6/22.
 * @Describe
 */
@Getter
@Setter
public class LoginLogQuery extends PageQuery{

    private String userId;

    private String userName;

    private String token;

    private String loginIp;

    private String beginDate;

    private String endDate;

}
