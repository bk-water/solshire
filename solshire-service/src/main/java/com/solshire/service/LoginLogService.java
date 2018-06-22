package com.solshire.service;

import com.github.pagehelper.PageInfo;
import com.solshire.model.LoginLogEntity;
import com.solshire.model.LoginLogQuery;
import com.solshire.model.domain.LoginLog;


public interface LoginLogService extends BaseService<LoginLog, Integer> {
    PageInfo<LoginLogEntity> queryByPage(LoginLogQuery query);
}