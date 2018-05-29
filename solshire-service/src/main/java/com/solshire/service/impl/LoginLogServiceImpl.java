package com.solshire.service.impl;

import com.solshire.model.domain.LoginLog;
import com.solshire.service.LoginLogService;
import org.springframework.stereotype.Service;

@Service("loginLogService")
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog, Integer> implements LoginLogService {
}