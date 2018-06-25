package com.solshire.config.shiro;

import com.google.gson.Gson;
import com.solshire.util.ResultBase;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author koabs
 * @Date 2018/6/25.
 * @Describe
 */
public class ShiroAccessFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(new Gson().toJson(ResultBase.instance().noPermissions("没有访问权限")));
        return false;
    }
}
