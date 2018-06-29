package com.solshire.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author koabs
 * @Date 2018/6/7.
 * @Describe
 * 合伙人,顾问,用户查询条件
 */
@Getter
@Setter
public class RichesQuery extends PageQuery{

    private Integer richeid;

    /**
     * 财富团队成员：bit0注册用户，bit1财富成员，bit2客户（保单持有人）
     * (按位运算)
     *  001 010 011 100 101 110 111
     *   1   2   3   4   5   6   7
     */
    private String flags;

    /**
     * 最高级别：0非事业合伙人，1事业合伙人
     */
    private Integer master;

    private String beginDate;

    private String endDate;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件号
     */
    @ApiModelProperty("证件号")
    private String certifyNo;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String tel;
}
