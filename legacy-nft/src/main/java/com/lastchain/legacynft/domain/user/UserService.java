package com.lastchain.legacynft.domain.user;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 느린 작업을 흉내 내서 캐시 효과 확인
    @Cacheable(value = "userById", key = "#id", unless = "#result == null")
    public UserDto findById(Long id) {
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        return new UserDto(id, "temp-user-" + id, System.currentTimeMillis());
    }

    // 캐시 무효화용 (테스트용)
    @CacheEvict(value = "userById", key = "#id")
    public void evictById(Long id) { /* no-op */ }
}
