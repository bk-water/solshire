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
@Table(name = "sol_context")
public class Context implements Serializable {
    /**
     * 自增量
     */
    @Id
    private Integer id;

    /**
     * 顾问ID
     */
    private Integer richeid;

    /**
     * 提交内容
     */
    private String context;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("richeid", richeid)
                .add("context", context)
                .toString();
    }
}