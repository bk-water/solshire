package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
    private Long parentId;

    /**
     * 权限code
     */
    private String code;

    /**
     * 判断是菜单还是按钮 1菜单 2按钮
     */
    private String type;

    private static final long serialVersionUID = 1L;

    public UserPermission(Long id, String url, String name, Long parentId, String code, String type) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.parentId = parentId;
        this.code = code;
        this.type = type;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("url", url)
                .add("name", name)
                .add("parentId", parentId)
                .add("code", code)
                .add("type", type)
                .toString();
    }
}