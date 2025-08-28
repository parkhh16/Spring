package com.lastchain.legacynft.global.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        // 키는 문자열, 값은 JSON 직렬화로
        RedisSerializationContext.SerializationPair<String> keyPair =
                RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());

        // GenericJackson2JsonRedisSerializer 사용 (타입 정보 포함)
        GenericJackson2JsonRedisSerializer jsonSerializer = new GenericJackson2JsonRedisSerializer(objectMapper());

        RedisSerializationContext.SerializationPair<Object> valuePair =
                RedisSerializationContext.SerializationPair.fromSerializer(jsonSerializer);

        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(keyPair)
                .serializeValuesWith(valuePair)
                .entryTtl(Duration.ofHours(1)); // 필요 시 TTL 조정

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .build();
    }

    private ObjectMapper objectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        return om;
    }
}
