package com.solshire.service;

import com.solshire.model.UserAdminInfo;
import com.solshire.model.domain.ShowData;
import com.solshire.model.domain.UserAdmin;

public interface UserAdminService extends BaseService<UserAdmin, Long> {
    UserAdminInfo queryInfoById(Long id);

    void save(UserAdmin info);
}