package com.solshire.service.impl;

import com.solshire.model.domain.UserAdminLoginLog;
import com.solshire.service.UserAdminLoginLogService;
import org.springframework.stereotype.Service;

@Service("userAdminLoginLogService")
public class UserAdminLoginLogServiceImpl extends BaseServiceImpl<UserAdminLoginLog, Long> implements UserAdminLoginLogService {
}