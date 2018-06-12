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
@Table(name = "sol_smsclient")
public class SMSClient implements Serializable {
    /**
     * 自增量
     */
    @Id
    private Integer id;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 短信验证码
     */
    private String code;

    /**
     * 状态：0未使用，1已使用
     */
    private Integer state;

    /**
     * 更新时间
     */
    private Date addtime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("tel", tel)
                .add("code", code)
                .add("state", state)
                .add("addtime", addtime)
                .toString();
    }
}