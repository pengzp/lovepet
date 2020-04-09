package com.pet.lovepet.config.shiro;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: lovepet
 * @description:
 * @author: Mr.peng
 * @create: 2020-04-08 21:17
 **/
@Slf4j
@Configuration
public class ShiroConfig {

    @Bean
    public CacheManager simpleCacheManager() {
        return  new CacheManager();
    }

    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager ehcacheManager = new EhCacheManager();
        ehcacheManager.setCacheManager(simpleCacheManager());
        ehcacheManager.setCacheManagerConfigFile("classpath:/ehcache.xml");
        return ehcacheManager;
    }

    /**
     * tips 自定义Realm
     *
     * @parameter: EhCacheManager ehCacheManager
     * @author: hihuzi 2018/8/26 13:04
     */
    @Bean
    public ShiroDbRealm realm(EhCacheManager ehCacheManager) {
        ShiroDbRealm realm = new ShiroDbRealm();
        realm.setCacheManager(ehCacheManager);
        return realm;
    }




    /**
     * tips 安全管理器
     *
     * @notice: 加入自定义的realm
     * @parameter:
     * @author: hihuzi 2018/9/10 15:31
     */
    @Bean
    public SecurityManager securityManager(ShiroDbRealm realm) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * tips 拦截配置
     *
     * @parametereter: SecurityManager securityManager
     * @return: ShiroFilterFactoryBean
     * @author: hihuzi 2018/9/26 14:51
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        log.info("shiro Permission interception...start");
        ShiroFilterFactoryBean shiro = new ShiroFilterFactoryBean();
        shiro.setSecurityManager(securityManager);
        shiro.setLoginUrl("/login");
        shiro.setSuccessUrl("/index");
        shiro.setUnauthorizedUrl("/403");
        Map<String, Filter> filters = shiro.getFilters();
        log.info("shiro Configure to release static resources...start");
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("/favicon.ico", "anon");
        map.put("/login", "anon");
        map.put("/logout", "logout");
        map.put("/js/**", "anon");
        map.put("/api/**", "anon");
        map.put("/css/**", "anon");
        map.put("/img/**", "anon");
        map.put("/index/showImg", "anon");
        map.put("/images/**", "anon");
        map.put("/docs/**", "anon");
        map.put("/fonts/**", "anon");
        map.put("/static/**", "anon");
        map.put("/login2/**", "anon");
        map.put("/assets/**", "anon");
        map.put("/user/**", "anon");
        /** 放行swaggerui **/
        map.put("/swagger-ui.html", "anon");
        map.put("/webjars/**","anon");
        map.put("/v2/**","anon");
        map.put("/swagger-resources/**","anon");
        map.put("/v1/**","anon");
        /**notice 放行小程序接口**/
        map.put("/applet/**", "anon");
        map.put("/**", "authc");
        shiro.setFilterChainDefinitionMap(map);
        return shiro;
    }


    /**
     * tips 开启shiro aop注解支持 使用代理方式;所以需要开启代码支持;
     *
     * @parameter: securityManager
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {

        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * tips 标签Html用于thymeleaf模板使用shiro标签
     *
     * @author: hihuzi 2018/9/10 15:32
     */
    /*@Bean
    public ShiroDialect shiroDialect() {

        return new ShiroDialect();
    }*/
}
