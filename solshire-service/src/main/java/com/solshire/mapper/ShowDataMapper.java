package com.solshire.mapper;

import com.solshire.model.ShowQuery;
import com.solshire.model.domain.ShowData;
import com.solshire.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShowDataMapper extends BaseMapper<ShowData> {

    List<ShowData> queryByPage(ShowQuery query);

}