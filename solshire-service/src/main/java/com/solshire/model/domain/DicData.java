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
@Table(name = "sol_data")
public class DicData implements Serializable {
    /**
     * 关键字
     */
    @Id
    private String key;

    /**
     * 关键值
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("key", key)
                .add("value", value)
                .add("remark", remark)
                .add("addtime", addtime)
                .toString();
    }
}