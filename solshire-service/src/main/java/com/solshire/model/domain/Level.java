package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_level")
public class Level implements Serializable {
    /**
     * 级别
     */
    @Id
    private Integer level;

    /**
     * 级别名称
     */
    private String name;

    /**
     * 购买保单金额
     */
    private Integer paymoney;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("level", level)
                .add("name", name)
                .add("paymoney", paymoney)
                .toString();
    }
}