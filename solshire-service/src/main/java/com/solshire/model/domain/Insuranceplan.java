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
@Table(name = "sol_insuranceplan")
public class Insuranceplan implements Serializable {
    /**
     * 计划书ID
     */
    @Id
    private Integer planid;

    /**
     * 性别：0女，1男
     */
    private Short sex;

    /**
     * 是否吸烟：0否，1是
     */
    private Short smoke;

    /**
     * 生日
     */
    private Date brithday;

    /**
     * 年龄（周岁）
     */
    private Integer age;

    /**
     * 0不追溯，1追溯
     */
    private Short retrospect;

    /**
     * 地区：1大陆，2香港
     */
    private Short region;

    /**
     * 公司名称
     */
    private String corporation;

    /**
     * 计划名称
     */
    private String productname;

    /**
     * 缴费年期
     */
    private Short payage;

    /**
     * 费用类型：1保费，2保额
     */
    private Short paytype;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 币种（0：人民币，1港币，2美元）
     */
    private Short currency;

    /**
     * 计划书PDF文件
     */
    private String file;

    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("planid", planid)
                .add("sex", sex)
                .add("smoke", smoke)
                .add("brithday", brithday)
                .add("age", age)
                .add("retrospect", retrospect)
                .add("region", region)
                .add("corporation", corporation)
                .add("productname", productname)
                .add("payage", payage)
                .add("paytype", paytype)
                .add("money", money)
                .add("currency", currency)
                .add("file", file)
                .add("addtime", addtime)
                .toString();
    }
}