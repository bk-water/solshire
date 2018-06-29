package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "sol_orderproduct")
public class OrderProduct implements Serializable {
    /**
     * 保单编号
     */
    @Id
    @Column(name = "policyNo")
    private String policyno;

    /**
     * 保险产品名称
     */
    @ApiModelProperty("保险产品名称")
    private String productname;

    /**
     * 保单持有人
     */
    @ApiModelProperty("policyowner")
    private String policyowner;

    /**
     * 保险公司名称
     */
    @ApiModelProperty("保险公司名称")
    private String corporation;

    /**
     * 缴费类型：1美金，2港币，3其它
     */
    @ApiModelProperty("缴费类型：1美金，2港币，3其它")
    private Short moneytype;

    /**
     * 缴费年期
     */
    @ApiModelProperty("缴费年期")
    private Short payage;

    /**
     * 每期保费
     */
    @ApiModelProperty("每期保费")
    private Float premium;

    /**
     * 保额（万）
     */
    @ApiModelProperty("保额（万）")
    private Float coverage;

    /**
     * 供款方式：1年缴，大于1预缴
     */
    @ApiModelProperty("供款方式：1年缴，大于1预缴")
    private Short pattern;

    /**
     * 产品费率ID
     */
    @ApiModelProperty("产品费率ID")
    private Integer feeid;

    /**
     * 顾问ID
     */
    @ApiModelProperty("顾问ID")
    private Integer richeid;

    /**
     * 保单状态：1已签，2已批，3已结算（顾问收到佣金）
     */
    @ApiModelProperty("保单状态：1已签，2已批，3已结算（顾问收到佣金）")
    private Integer state;

    /**
     * 保单生效日期
     */
    @ApiModelProperty("保单生效日期")
    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("policyno", policyno)
                .add("productname", productname)
                .add("policyowner", policyowner)
                .add("corporation", corporation)
                .add("moneytype", moneytype)
                .add("payage", payage)
                .add("premium", premium)
                .add("coverage", coverage)
                .add("pattern", pattern)
                .add("feeid", feeid)
                .add("richeid", richeid)
                .add("state", state)
                .add("addtime", addtime)
                .toString();
    }
}