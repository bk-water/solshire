package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "sol_richeplans")
public class RichePlans implements Serializable {
    /**
     * 自增量
     */
    @Id
    private Integer id;

    /**
     * 计划书ID
     */
    @ApiModelProperty("计划书ID")
    private Integer planid;

    /**
     * 附加条款
     */
    @ApiModelProperty("附加条款")
    private String attach;

    /**
     * 提取演示（N年后可提取）
     */
    @ApiModelProperty("提取演示（N年后可提取）")
    private Short returnS;

    /**
     * 备注（个性化提取演示）
     */
    @ApiModelProperty("备注（个性化提取演示）")
    private String remark;

    /**
     * 生成计划书时间
     */
    private Date addtime;

    /**
     * 顾问ID
     */
    @ApiModelProperty("顾问ID")
    private Integer richeid;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("planid", planid)
                .add("attach", attach)
                .add("return", returnS)
                .add("remark", remark)
                .add("addtime", addtime)
                .add("richeid", richeid)
                .toString();
    }
}