package com.github.dolphineor.springboot.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Objects;

/**
 * Created on 2016-01-07.
 *
 * @author dolphineor
 */
@Configuration
public class RolesAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;
        if (Objects.isNull(rolesArray) || rolesArray.length == 0) {
            // 没有角色限制, 有访问权限
            return true;
        }

        for (int i = 0, l = rolesArray.length; i < l; i++) {
            if (subject.hasRole(rolesArray[i])) {
                // 若当前用户是rolesArray中的任何一个, 则有访问权限
                return true;
            }
        }

        return false;
    }
}
