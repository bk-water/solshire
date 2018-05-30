package com.solshire.service.impl;

import com.solshire.model.domain.UserPermission;
import com.solshire.service.UserPermissionService;
import org.springframework.stereotype.Service;

@Service("userPermissionService")
public class UserPermissionServiceImpl extends BaseServiceImpl<UserPermission, Long> implements UserPermissionService {
}