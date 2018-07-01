package com.solshire.config.shiro;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author koabs
 * @Date 2018/5/29.
 * @Describe
 */
@Configuration
public class ShiroConfig {
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
    //指定加密方式方式，也可以在这里加入缓存，当用户超过五次登陆错误就锁定该用户禁止不断尝试登陆
//    @Bean(name = "hashedCredentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        credentialsMatcher.setHashAlgorithmName("MD5");
//        credentialsMatcher.setHashIterations(2);
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);
//        return credentialsMatcher;
//    }

    @Bean(name = "shiroRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public ShiroRealm shiroRealm() {
        ShiroRealm realm = new ShiroRealm();
//        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    @Bean(name = "ehCacheManager")
    @DependsOn("lifecycleBeanPostProcessor")
    public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        return ehCacheManager;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setCacheManager(ehCacheManager());//用户授权/认证信息Cache, 采用EhCache 缓存
        return securityManager;
    }


    public ShiroAccessFilter accessFilter(){
        ShiroAccessFilter accessFilter = new ShiroAccessFilter();
        return accessFilter;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager  securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, Filter> filtersMap = new LinkedHashMap();
        filtersMap.put("authc", accessFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<>();
        filterChainDefinitionManager.put("/kaptcha/**", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/loginOut", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/login", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/*swagger*/**", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/v2/api-docs", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/webjars/**", "anon");//anon 可以理解为不拦截

        filterChainDefinitionManager.put("/**",  "anon");//其他资源全部拦截
//        filterChainDefinitionManager.put("/ajaxLogin", "anon");//anon 可以理解为不拦截
//        filterChainDefinitionManager.put("/statistic/**",  "anon");//静态资源不拦截
//        filterChainDefinitionManager.put("/**",  "authc,roles[user]");//其他资源全部拦截
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        shiroFilterFactoryBean.setSuccessUrl("/");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        return shiroFilterFactoryBean;
    }


    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager);
        return aasa;
    }
}
