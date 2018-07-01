package com.solshire.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: koabs
 * 2018/7/1.
 */
@Setter
@Getter
public class ShowQuery extends PageQuery{

    private String id;

    private String name;

    private String tip;

    private String type;
}
