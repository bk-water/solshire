package com.solshire.model;

import com.solshire.model.domain.OrderProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * @Author koabsguwen
 * @Date 2018/6/21.
 * @Describe
 */
@Getter
@Setter
public class OrderProductEntity extends OrderProduct {


    /**
     *顧問名
     */
    @ApiModelProperty("顧問名")
    private String adviserName;


    /**
     * 标准保费
     * 需计算获取
     */
    @ApiModelProperty("标准保费")
    private Float ape;

    public Float getApe() {
        return getPremium();
    }


    /**
     * 保费到期日
     */
    @ApiModelProperty("保费到期日")
    private Date paymentDate;

    /**
     * 保单期满日
     */
    @ApiModelProperty("保单期满日")
    private String expiryDate;

    /**
     * 缴费形式
     */
    @ApiModelProperty("缴费形式")
    private String patternName;

    @ApiModelProperty("被保险人")
    private String recognizeeName;


    public String getPatternName() {
        patternName = "年缴";
        if (getPattern()>1) {
            patternName = "月缴";
        }
        return patternName;
    }

    public String getPaymentDate() {
        if (getAddtime()!= null) {
            DateTime addTime = new DateTime(getAddtime());
            String monthDay;
            String year;
            if (getPattern() > 1) {
                year = DateTime.now().toString("yyyy");
                monthDay = addTime.plusMonths(1).toString("MM-dd");
            } else {
                year = DateTime.now().plusYears(1).toString("yyyy");
                monthDay = addTime.toString("MM-dd");
            }
            expiryDate = year + "年" + monthDay.replace("-","月") + "日";
        }
        return expiryDate;
    }

}
