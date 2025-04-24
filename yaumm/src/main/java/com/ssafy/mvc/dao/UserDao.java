// src/main/java/com/nyamcochi/dao/UserDao.java
package com.ssafy.mvc.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.mvc.dto.UserDto;

public interface UserDao {
    void insertUser(UserDto user);
    UserDto login(Map<String, String> loginMap);
    void deleteUser(String userId);
    void updateUser(UserDto user);
    List<UserDto> selectAllUsers();
    UserDto findById(String userId);
}
