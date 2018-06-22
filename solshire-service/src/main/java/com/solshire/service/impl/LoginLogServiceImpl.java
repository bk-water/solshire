package com.solshire.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.solshire.mapper.LoginLogMapper;
import com.solshire.model.LoginLogEntity;
import com.solshire.model.LoginLogQuery;
import com.solshire.model.RichesEntity;
import com.solshire.model.domain.LoginLog;
import com.solshire.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginLogService")
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog, Integer> implements LoginLogService {

    @Autowired
    LoginLogMapper loginLogMapper;

    @Override
    public PageInfo<LoginLogEntity> queryByPage(LoginLogQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<LoginLogEntity> result = loginLogMapper.queryByPage(query);
        return new PageInfo<>(result);
    }
}