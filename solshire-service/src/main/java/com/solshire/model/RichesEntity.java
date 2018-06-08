package com.solshire.model;

import com.solshire.model.domain.Riches;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author koabs
 * @Date 2018/6/7.
 * @Describe
 */
@Getter
@Setter
public class RichesEntity extends Riches{

    /**
     * 对应的财富等级
     */
    private String level;

    /**
     * 财富等级名称
     */
    private String levelName;


    public String getLevelName() {
        return levelName;
    }
}
