package com.solshire.mapper;

import com.solshire.model.LoginLogEntity;
import com.solshire.model.LoginLogQuery;
import com.solshire.model.domain.LoginLog;
import com.solshire.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

    List<LoginLogEntity> queryByPage(LoginLogQuery query);

}