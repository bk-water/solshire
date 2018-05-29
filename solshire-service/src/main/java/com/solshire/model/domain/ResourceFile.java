package com.solshire.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "sol_resource_file")
public class ResourceFile implements Serializable {
    /**
     * 自增量
     */
    @Id
    private Integer fileid;

    /**
     * 资源类型ID
     */
    private Integer resid;

    /**
     * PDF文件
     */
    private String filename;

    /**
     * 文件路径
     */
    private String filepath;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 操作人
     */
    private String author;

    /**
     * 添加时间
     */
    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("fileid", fileid)
                .add("resid", resid)
                .add("filename", filename)
                .add("filepath", filepath)
                .add("sort", sort)
                .add("author", author)
                .add("addtime", addtime)
                .toString();
    }
}