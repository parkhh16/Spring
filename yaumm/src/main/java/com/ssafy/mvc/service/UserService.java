// src/main/java/com/nyamcochi/service/UserService.java
package com.ssafy.mvc.service;

import java.util.List;

import com.ssafy.mvc.dto.UserDto;

public interface UserService {
    void register(UserDto user);                    // 회원가입
    UserDto login(String userId, String password);  // 로그인
    void deleteUser(String userId);                 // 회원 삭제
    void updateUser(UserDto user);                  // 회원 정보 수정
    List<UserDto> getAllUsers();                    // 전체 사용자 조회
    UserDto findUserById(String userId);            // 특정 사용자 상세 조회
}
