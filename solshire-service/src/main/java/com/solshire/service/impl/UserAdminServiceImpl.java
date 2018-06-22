package com.solshire.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.solshire.model.UserAdminInfo;
import com.solshire.model.domain.UserAdmin;
import com.solshire.model.domain.UserRole;
import com.solshire.model.domain.UserRoleRel;
import com.solshire.service.UserAdminService;
import com.solshire.service.UserRoleRelService;
import com.solshire.service.UserRoleService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;

@Service("userAdminService")
public class UserAdminServiceImpl extends BaseServiceImpl<UserAdmin, Long> implements UserAdminService {
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserRoleRelService userRoleRelService;

    @Override
    public UserAdminInfo queryInfoById(Long id){
        UserAdmin userAdmin = super.selectByPk(id);
        UserRoleRel query = new UserRoleRel();
        query.setUid(id);
        List<UserRoleRel> roleRelList = userRoleRelService.select(query);
        List<Long> roleIds = Lists.transform(roleRelList, new Function<UserRoleRel, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable UserRoleRel userRoleRel) {
                return userRoleRel.getRid();
            }
        });
        List<UserRole> roles = userRoleService.selectByIds(roleIds);
        return UserAdminInfo.build(userAdmin,roles);
    }
}