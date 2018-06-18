package com.solshire.util;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Author: koabs
 * 2018/6/18.
 */
public class TreeJson {
    private String url;
    private String name;
    private String id;  //节点
    private String parent; //父节点
    private List<TreeJson> children= Lists.newArrayList(); //存放子节点

}
