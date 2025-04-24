package com.ssafy.mvc.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.mvc.config.WebConfig;
import com.ssafy.mvc.controller.BoardController;
import com.ssafy.mvc.dao.UserDao;
import com.ssafy.mvc.dto.UserDto;
import com.ssafy.mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final BoardController boardController;

    private final BoardServiceImpl boardServiceImpl;

    private final WebConfig webConfig;

    @Autowired
    private UserDao userDao;

    UserServiceImpl(WebConfig webConfig, BoardServiceImpl boardServiceImpl, BoardController boardController) {
        this.webConfig = webConfig;
        this.boardServiceImpl = boardServiceImpl;
        this.boardController = boardController;
    }

    @Override
    public void register(UserDto user) {
        userDao.insertUser(user);
    }

    @Override
    public UserDto login(String userId, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("password", password);
        return userDao.login(map);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(UserDto user) {
        userDao.updateUser(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public UserDto findUserById(String userId) {
        return userDao.findById(userId);
    }
}
