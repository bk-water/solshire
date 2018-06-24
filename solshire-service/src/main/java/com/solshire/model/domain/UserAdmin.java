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
@Table(name = "user_admin")
public class UserAdmin implements Serializable {
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
     * 密码
     */
    private String pswd;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 1:有效，0:禁止登录
     */
    private Long status;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("nickname", nickname)
                .add("email", email)
                .add("pswd", pswd)
                .add("createTime", createTime)
                .add("lastLoginTime", lastLoginTime)
                .add("lastLoginIp", lastLoginIp)
                .add("status", status)
                .toString();
    }
}