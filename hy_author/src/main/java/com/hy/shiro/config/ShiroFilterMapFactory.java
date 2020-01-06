package com.hy.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShiroFilterMapFactory {

	public static Map<String, String> shiroFilterMap() {
//		设置路径映射，注意这里要用LinkedHashMap 保证有序
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/welcome", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/user", "roles[user]");
		filterChainDefinitionMap.put("/admin", "roles[admin]");
		filterChainDefinitionMap.put("/**", "user");//user允许 记住我和授权用户 访问，但在进行下单和支付时建议使用authc

		return filterChainDefinitionMap;
	}
}