package com.solshire.model;

import com.solshire.model.domain.Riches;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author koabs
 * @Date 2018/6/21.
 * @Describe
 * 保单客户信息
 */
@Getter
@Setter
public class ConsumerEntity extends Riches {

    /**
     * 顾问ID
     */
    private Integer adviserId;

    /**
     * 用戶名
     */
    private String adviserName;


}
