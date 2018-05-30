package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_role_permission")
public class UserRolePermission implements Serializable {
    @Id
    private Long id;

    /**
     * 角色ID
     */
    private Long rid;

    /**
     * 权限ID
     */
    private Long pid;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("rid", rid)
                .add("pid", pid)
                .toString();
    }
}