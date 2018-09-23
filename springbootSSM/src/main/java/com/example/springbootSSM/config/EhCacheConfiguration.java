package com.example.springbootSSM.config;


import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 配置ehcache缓存，springboot默认的缓存方式（concurrentMapCache)替换不了
 */
@Configuration
@EnableCaching
public class EhCacheConfiguration {
    @Bean(name = "EhCacheManager")
    public EhCacheCacheManager ehCacheManager(CacheManager bean) {
        return new EhCacheCacheManager(bean);
    }
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }
}
