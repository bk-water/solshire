package com.solshire.mapper;

import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;
import com.solshire.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RichesMapper extends BaseMapper<Riches> {

    List<RichesEntity> queryByPage(RichesQuery query);
}