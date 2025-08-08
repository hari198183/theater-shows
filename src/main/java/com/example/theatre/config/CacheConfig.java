package com.example.theatre.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
    // For brevity, rely on Spring Boot auto-config for RedisCacheManager.
}
