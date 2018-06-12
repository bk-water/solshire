package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_admin_login_log")
public class UserAdminLoginLog implements Serializable {
    @Id
    private Long id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱|登录帐号
     */
    private String email;

    /**
     * 最后登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 登入IP
     */
    @Column(name = "login_ip")
    private String loginIp;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("nickname", nickname)
                .add("email", email)
                .add("loginTime", loginTime)
                .add("loginIp", loginIp)
                .toString();
    }
}