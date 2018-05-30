package com.solshire.service.impl;

import com.solshire.model.domain.UserRolePermission;
import com.solshire.service.UserRolePermissionService;
import org.springframework.stereotype.Service;

@Service("userRolePermissionService")
public class UserRolePermissionServiceImpl extends BaseServiceImpl<UserRolePermission, Long> implements UserRolePermissionService {
}