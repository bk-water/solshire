package com.solshire.service.impl;

import com.solshire.model.domain.UserRole;
import com.solshire.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Long> implements UserRoleService {
}