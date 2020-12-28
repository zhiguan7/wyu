package com.wyu.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("des") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加过滤器，拦截
        HashMap<String,String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/index","anon");
        //授权
//        filterChainDefinitionMap .put("/human/*","authc");
        filterChainDefinitionMap.put("/logout","logout");
//        filterChainDefinitionMap .put("/human/add","perms[1]");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean(name = "des")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("ur") UserRealm UserRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(UserRealm);
        return  securityManager;
    }

    @Bean(name="ur")
    public UserRealm userRealm(HashedCredentialsMatcher matcher){
        UserRealm userRealm = new UserRealm();
        userRealm.setAuthorizationCachingEnabled(false);
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-512");
        // 设置加密次数
        hashedCredentialsMatcher.setHashIterations(101);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }
}

