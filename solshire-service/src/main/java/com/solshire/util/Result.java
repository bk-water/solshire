package com.solshire.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author koabs
 * @Date 2018/5/30.
 * @Describe
 */
@Getter
@Setter
public class Result<T> extends ResultBase{

    private T data;

    public  Result success(T data) {
        super.success();
        this.data = data;
        return this;
    }

    public static <T> Result<T> instance(Class<T> iclazz) {
        return new Result<>();
    }

}
