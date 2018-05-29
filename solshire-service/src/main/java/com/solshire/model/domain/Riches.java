package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_riches")
public class Riches implements Serializable {
    /**
     * 顾问ID
     */
    @Id
    private Integer richeid;

    /**
     * 用户名
     */
    private String name;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 证件号
     */
    @Column(name = "certifyNo")
    private String certifyno;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 性别：0女，1男
     */
    private Short sex;

    /**
     * 状态：0正在审核，1正常，2已解约
     */
    private Short state;

    /**
     * 银行卡号
     */
    private String bankcardid;

    /**
     * 银行卡持卡姓名
     */
    private String bankcardname;

    /**
     * 登陆密码
     */
    private String pwd;

    /**
     * 微信小程序ID
     */
    @Column(name = "openID")
    private String openid;

    /**
     *  顾问图像
     */
    private String img;

    /**
     * 财富团队成员：bit0注册用户，bit1财富成员，bit2客户（保单持有人）
     */
    private Integer flag;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最高级别：0非事业合伙人，1事业合伙人
     */
    private Integer master;

    /**
     * 登陆token
     */
    private String token;

    /**
     * 签约时间
     */
    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("richeid", richeid)
                .add("name", name)
                .add("realname", realname)
                .add("certifyno", certifyno)
                .add("tel", tel)
                .add("sex", sex)
                .add("state", state)
                .add("bankcardid", bankcardid)
                .add("bankcardname", bankcardname)
                .add("pwd", pwd)
                .add("openid", openid)
                .add("img", img)
                .add("flag", flag)
                .add("email", email)
                .add("remark", remark)
                .add("master", master)
                .add("token", token)
                .add("addtime", addtime)
                .toString();
    }
}