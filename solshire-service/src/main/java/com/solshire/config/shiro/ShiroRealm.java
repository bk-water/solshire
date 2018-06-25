package com.solshire.config.shiro;

import com.solshire.model.domain.UserAdmin;
import com.solshire.service.UserAdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author koabs
 * @Date 2018/5/29.
 * @Describe
 */
@Slf4j
public class ShiroRealm  extends AuthorizingRealm {

    @Autowired
    UserAdminService userAdminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        UserAdmin query = new UserAdmin();
        query.setEmail(userName);
        UserAdmin userAdmin = userAdminService.selectOne(query);
        if (userAdmin == null) {
            log.error("认证：当前登录的用户不存在" + userName);
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(userAdmin, userAdmin.getPswd(), getName());
    }


}
