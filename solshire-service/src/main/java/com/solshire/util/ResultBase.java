package com.solshire.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author koabs
 * @Date 2018/5/30.
 * @Describe
 */
@Getter
@Setter
public class ResultBase<T> {
    // 返回状态码仿照http 状态码
    private String code;
    private String msg;
    private List<T> data;

    public static <T> ResultBase success(List list,T t) {
        ResultBase<T> result = new ResultBase();
        result.code = "200";
        result.msg = "Success";
        result.data = list;
        return result;
    }

}
