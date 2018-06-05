package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
    @ApiModelProperty(notes = "用户昵称")
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
                .add("status", status)
                .toString();
    }
}