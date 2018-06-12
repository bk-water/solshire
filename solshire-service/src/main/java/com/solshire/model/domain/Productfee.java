package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_productfee")
public class Productfee implements Serializable {
    /**
     * 产品费率ID
     */
    @Id
    private Integer feeid;

    /**
     * 保险公司名称
     */
    private String company;

    /**
     * 保险产品名称
     */
    private String productname;

    /**
     * 缴费年期
     */
    private Short payage;

    /**
     * 首年年供奖赏比率
     */
    private Float reward;

    /**
     * 基准佣金比率（如5年期 0.35，0.23，0.1，0.03，0.03）
     */
    private String fee;

    /**
     * 首年佣金收入比率
     */
    private Float firstrate;

    /**
     * 次年佣金收入比率
     */
    private Float secondrate;

    /**
     * 币种（0：人民币，1港币，2美元）
     */
    private Short currency;

    /**
     * 首年业绩佣金比率
     */
    private Float firstfee;

    /**
     * 次年业绩佣金比率
     */
    private Float secondfee;

    /**
     * 首年直属佣金比率
     */
    private Float firstdirectly;

    /**
     * 次年直属佣金比率
     */
    private Float seconddirectly;

    /**
     * 首年管理佣金比率
     */
    private Float firstmanage;

    /**
     * 次管理佣金比率
     */
    private Float secondmanage;

    /**
     * 首年渠道佣金比率
     */
    private Float firstchannel;

    /**
     * 次年渠道佣金比率
     */
    private Float secondchannel;

    /**
     * 添加时间
     */
    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("feeid", feeid)
                .add("company", company)
                .add("productname", productname)
                .add("payage", payage)
                .add("reward", reward)
                .add("fee", fee)
                .add("firstrate", firstrate)
                .add("secondrate", secondrate)
                .add("currency", currency)
                .add("firstfee", firstfee)
                .add("secondfee", secondfee)
                .add("firstdirectly", firstdirectly)
                .add("seconddirectly", seconddirectly)
                .add("firstmanage", firstmanage)
                .add("secondmanage", secondmanage)
                .add("firstchannel", firstchannel)
                .add("secondchannel", secondchannel)
                .add("addtime", addtime)
                .toString();
    }
}