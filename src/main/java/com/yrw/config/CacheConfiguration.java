package com.yrw.config;

import javax.annotation.PreDestroy;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration{
	
	private net.sf.ehcache.CacheManager cacheManager;

    @PreDestroy
    public void destroy() {
        cacheManager.shutdown();
    }

    @Bean
    public CacheManager cacheManager() {
        cacheManager = net.sf.ehcache.CacheManager.create();
        EhCacheCacheManager ehCacheManager = new EhCacheCacheManager();
        ehCacheManager.setCacheManager(cacheManager);
        return ehCacheManager;
    }
}
