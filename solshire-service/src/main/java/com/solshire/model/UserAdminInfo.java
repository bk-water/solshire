package com.solshire.model;

import com.solshire.model.domain.UserAdmin;
import com.solshire.model.domain.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Author: koabs
 * 2018/6/18.
 */

@Getter
@Setter
public class UserAdminInfo extends UserAdmin{

    String roleName;
    String roleId;
    String roleDesc;


    public static UserAdminInfo build(UserAdmin userAdmin, List<UserRole> roles) {
        UserAdminInfo userAdminInfo = new UserAdminInfo();
        userAdminInfo.setRoleName("超级管理员");
        userAdminInfo.setRoleDesc("拥有系统最高权限");
        userAdminInfo.setLastLoginIp("192.11.22.45");
        userAdminInfo.setLastLoginTime(new Date());
        userAdminInfo.setNickname("Admin");
        userAdminInfo.setCreateTime(new Date());
        return userAdminInfo;
    }

}
