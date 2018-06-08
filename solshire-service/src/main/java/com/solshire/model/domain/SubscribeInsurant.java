package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_subscribe_insurant")
public class SubscribeInsurant implements Serializable {
    /**
     * 自增量
     */
    @Id
    private Integer id;

    /**
     * 预约订单号
     */
    private Integer orderid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 拼音姓名
     */
    @Column(name = "Ename")
    private String ename;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别：0女，1男
     */
    private Short sex;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 国籍
     */
    private String nation;

    /**
     * 学历：1小学或以上，2中学，3大专或以上
     */
    private Short educate;

    /**
     * 婚姻状况：0未婚， 1已婚 ， 2离异， 3丧偶
     */
    private Short marriage;

    /**
     * 是否吸烟：0否，1是
     */
    private Short smoke;

    /**
     * 身高(cm)
     */
    private Float stature;

    /**
     * 体重（KG）
     */
    private Float weight;

    /**
     * 证件号
     */
    @Column(name = "certifyNo")
    private String certifyno;

    /**
     * 护照/通行证号码
     */
    @Column(name = "permitNo")
    private String permitno;

    /**
     * 证件号地址
     */
    @Column(name = "certifyAddr")
    private String certifyaddr;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 公司名称
     */
    private String corporation;

    /**
     * 公司地址
     */
    private String site;

    /**
     * 公司职位
     */
    private String title;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 年薪
     */
    private Integer salary;

    /**
     * 上传身份证，体检等信息
     */
    private String file;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("orderid", orderid)
                .add("name", name)
                .add("ename", ename)
                .add("birthday", birthday)
                .add("sex", sex)
                .add("tel", tel)
                .add("nation", nation)
                .add("educate", educate)
                .add("marriage", marriage)
                .add("smoke", smoke)
                .add("stature", stature)
                .add("weight", weight)
                .add("certifyno", certifyno)
                .add("permitno", permitno)
                .add("certifyaddr", certifyaddr)
                .add("address", address)
                .add("corporation", corporation)
                .add("site", site)
                .add("title", title)
                .add("email", email)
                .add("salary", salary)
                .add("file", file)
                .toString();
    }
}