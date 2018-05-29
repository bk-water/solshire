package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_richegroup")
public class RicheGroup implements Serializable {
    @Id
    private Integer id;

    /**
     * 子ID
     */
    private Integer cid;

    /**
     * 父ID
     */
    private Integer pid;

    /**
     * 邀请添加时间
     */
    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("cid", cid)
                .add("pid", pid)
                .add("addtime", addtime)
                .toString();
    }
}