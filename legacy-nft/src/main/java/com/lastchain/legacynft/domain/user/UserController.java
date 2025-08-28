package com.lastchain.legacynft.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo/users")
public class UserController {

    private final UserService userService;

    // 1) 조회: 첫 호출은 ~1초(캐시 적재), 같은 id 재호출은 즉시 응답
    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return userService.findById(id);
    }

    // 2) 캐시 비우기(테스트): 다음 호출이 다시 느려짐(다시 캐시 적재)
    @DeleteMapping("/{id}/cache")
    public String evict(@PathVariable Long id) {
        userService.evictById(id);
        return "cache evicted for user " + id;
    }
}
