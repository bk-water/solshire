package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_feeorders")
public class Feeorders implements Serializable {
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
     * 第几年,1为首年，2为次年
     */
    private Integer times;

    /**
     * 佣金值
     */
    private Float value;

    /**
     * 从保险公司收到的佣金值
     */
    private Float receive;

    /**
     * 添加时间
     */
    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("policyno", policyno)
                .add("times", times)
                .add("value", value)
                .add("receive", receive)
                .add("addtime", addtime)
                .toString();
    }
}