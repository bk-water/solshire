package com.solshire.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: koabs
 * 2018/6/24.
 */

@Setter
@Getter
public class ProductQuery extends PageQuery{

    private String beginDate;

    private String endDate;

    /**
     * 顾问名称
     */
    private String adviserName;

    /**
     * 保单号
     */
    private String policyNo;

    /**
     * 保险公司
     */
    private String corporation;

    /**
     * 保险产品名称
     */
    private String productname;

}
