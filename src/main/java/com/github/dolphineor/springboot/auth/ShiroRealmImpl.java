package com.github.dolphineor.springboot.auth;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Objects;

/**
 * Created on 2016-01-07.
 *
 * @author dolphineor
 */
public class ShiroRealmImpl extends AuthorizingRealm {

    /**
     * 授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = principals.getPrimaryPrincipal().toString();

        // TODO 从数据库中获取用户信息
        Object user = null;
        if (Objects.isNull(user)) {
            throw new UnknownAccountException();
        } else {
            SimpleAuthorizationInfo result = new SimpleAuthorizationInfo();
            // 封装用户权限
            result.addRole("");
            result.addObjectPermission(null);

            return result;
        }
    }

    /**
     * 认证信息
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // TODO 从数据库中获取用户信息
        // 将从数据库中查询的用户名和密码封装到authenticationInfo对象中, shiro自动根据加密规则将前台的密码加密与之对比
        return new SimpleAuthenticationInfo("", "", getName());

//        throw new UnknownAccountException();
    }
}
