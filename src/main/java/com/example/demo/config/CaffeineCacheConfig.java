package com.example.demo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineCacheConfig {

	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(
				Caffeine.newBuilder()
				.expireAfterAccess(600, TimeUnit.SECONDS)
				.initialCapacity(100).
				maximumSize(500));
		return cacheManager;
	}

}
