package com.solshire.service.impl;

import com.solshire.model.domain.UserAdmin;
import com.solshire.service.UserAdminService;
import org.springframework.stereotype.Service;

@Service("userAdminService")
public class UserAdminServiceImpl extends BaseServiceImpl<UserAdmin, Long> implements UserAdminService {
}