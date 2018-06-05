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
public class ResultBase {
    // 返回状态码仿照http 状态码
    private String code;
    private String msg;

    public static ResultBase instance() {
        return new ResultBase();
    }

    public ResultBase success() {
        this.code = "200";
        this.msg = "Success";
        return this;
    }

    public ResultBase success(String msg) {
        this.code = "200";
        this.msg = msg;
        return this;
    }

    public ResultBase fail() {
        this.code = "500";
        this.msg = "Fail";
        return this;
    }

    public ResultBase fail(String msg) {
        this.code = "500";
        this.msg = msg;
        return this;
    }

    public ResultBase noPermissions() {
        this.code = "403";
        this.msg = "no permissions!";
        return this;
    }

    public ResultBase noPermissions(String msg) {
        this.code = "403";
        this.msg = msg;
        return this;
    }
}
