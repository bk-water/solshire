package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_login_log")
public class LoginLog implements Serializable {
    /**
     * 自增量
     */
    @Id
    private Integer id;

    /**
     * 登陆名
     */
    private String name;

    /**
     * 登陆token
     */
    private String token;

    /**
     * 登陆IP
     */
    @Column(name = "loginIp")
    private String loginip;

    /**
     * 手机系统信息
     */
    @Column(name = "sysInfo")
    private String sysinfo;

    /**
     * 最近登陆时间
     */
    @Column(name = "loginTime")
    private Date logintime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("name", name)
                .add("token", token)
                .add("loginip", loginip)
                .add("sysinfo", sysinfo)
                .add("logintime", logintime)
                .toString();
    }
}