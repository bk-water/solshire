package com.solshire.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author koabs
 * @Date 2018/6/7.
 * @Describe
 */
@Getter
@Setter
public class PageQuery {
    private Integer pageNum =1;
    private Integer pageSize = 10;
}
