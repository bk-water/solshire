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
@Table(name = "sol_feeriches")
public class Feeriches implements Serializable {
    /**
     * 自增量
     */
    @Id
    private Integer id;

    /**
     * 保单编号
     */
    @Column(name = "policyNo")
    private String policyno;

    /**
     * 顾问佣金
     */
    private Float fee;

    /**
     * 类型：1首年业绩佣金，2次年业绩佣金，3首年直属佣金，4次年直属佣金，5首年管理佣金，6次管理佣金，7首年渠道佣金，8次年渠道佣金
     */
    private Integer type;

    /**
     * 顾问ID
     */
    private Integer richeid;

    /**
     * 服务费用
     */
    private Float minus;

    /**
     * 美元对人民币汇率
     */
    private Float exchange;

    /**
     * 状态：1核审，2异常，3已发放
     */
    private Integer state;

    /**
     * 说明备注
     */
    private String remark;

    /**
     * 支付时间
     */
    private Date paytime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("policyno", policyno)
                .add("fee", fee)
                .add("type", type)
                .add("richeid", richeid)
                .add("minus", minus)
                .add("exchange", exchange)
                .add("state", state)
                .add("remark", remark)
                .add("paytime", paytime)
                .toString();
    }
}