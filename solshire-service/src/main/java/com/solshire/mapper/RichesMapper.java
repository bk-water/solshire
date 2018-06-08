package com.solshire.mapper;

import com.github.pagehelper.PageInfo;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;
import com.solshire.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.rx.stream.LiftStream;

import java.util.List;

@Mapper
public interface RichesMapper extends BaseMapper<Riches> {

    List<RichesEntity> queryByPage(RichesQuery query);
}