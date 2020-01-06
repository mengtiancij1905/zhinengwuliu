/*
package com.hy.shiro.realm;

import com.hy.pojo.User;
import com.hy.utils.MD5Utils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

//继承AuthorizingRealm，重写认证和授权方法
public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private UserMapper userMapper;

	*/
/**
	 * 授权方法，如果不设置缓存管理的话，需要访问需要一定的权限或角色的请求时会进入这个方法
	 *//*

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User principal = (User) principals.getPrimaryPrincipal();
		Set<String> roles = new HashSet<>();
		roles.add("user");
		if("admin".equals(principal.getUsername())){
			roles.add("admin");
		}
		
		return new SimpleAuthorizationInfo(roles);
	}

	*/
/**
	 * 认证方法
	 *//*

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken userToken=(UsernamePasswordToken) token;
		User userInfo=userMapper.findByUserName(userToken.getUsername());
		String pwd =userInfo.getPassword();
		String repwd= MD5Utils.md5(pwd,userInfo.getUsername(),1);

		
		if(userInfo == null) {
			throw new IncorrectCredentialsException("用户名或密码不正确");
		}
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	                userInfo,//用户
	                repwd,//密码
	                ByteSource.Util.bytes(userInfo.getUsername()),//盐值用 ByteSource.Util.bytes 来生成
	                getName()//realm name
	        );
		return authenticationInfo;
	}
}*/
