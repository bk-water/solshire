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
@Table(name = "sol_resource_type")
public class ResourceType implements Serializable {
    /**
     * 资源ID
     */
    @Id
    private Integer resid;

    /**
     * 名称
     */
    private String name;

    /**
     * logo图片
     */
    private String image;

    /**
     * 父ID
     */
    private Integer pid;

    /**
     * 排序（从小到大升序）
     */
    private Integer sort;

    /**
     * 0隐藏，1显示
     */
    private Integer hide;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("resid", resid)
                .add("name", name)
                .add("image", image)
                .add("pid", pid)
                .add("sort", sort)
                .add("hide", hide)
                .toString();
    }
}