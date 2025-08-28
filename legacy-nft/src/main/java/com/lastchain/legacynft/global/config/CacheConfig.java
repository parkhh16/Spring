package com.lastchain.legacynft.global.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
    // 최소 구성: 애노테이션만 있으면 됨 (기본 RedisCacheManager 자동 구성)
}