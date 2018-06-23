package com.solshire.mapper;

import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;
import com.solshire.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RichesMapper extends BaseMapper<Riches> {

    List<RichesEntity> queryByPage(RichesQuery query);

    /**
     * 获取下级
     * @param query
     * @return
     */
    List<RichesEntity> queryChildren(RichesQuery query);

    /**
     * 获取用户级别
     * @param richeid
     * @return
     */
    Integer queryLevel(@Param("richeid") Integer richeid, @Param("type")Integer type);
}