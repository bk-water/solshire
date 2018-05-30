package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_permission")
public class UserPermission implements Serializable {
    @Id
    private Long id;

    /**
     * url地址
     */
    private String url;

    /**
     * url描述
     */
    private String name;

    /**
     * 父节点id
     */
    @Column(name = "parentId")
    private Long parentid;

    /**
     * 权限code
     */
    private String code;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("url", url)
                .add("name", name)
                .add("parentid", parentid)
                .add("code", code)
                .toString();
    }
}