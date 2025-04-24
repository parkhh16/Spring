// src/main/java/com/nyamcochi/controller/UserController.java
package com.ssafy.controller;

import com.ssafy.dto.UserDTO;
import com.ssafy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE - 회원가입 폼
    @GetMapping("/register")
    public String showRegisterForm() {
        return "user/register"; // register.jsp
    }

    // CREATE - 회원가입 처리
    @PostMapping("/register")
    public String register(UserDTO user) {
        userService.register(user);
        return "redirect:/user/login";
    }

    // READ - 전체 사용자 목록
    @GetMapping("/list")
    public String list(Model model) {
        List<UserDTO> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "user/list"; // list.jsp
    }

    // READ - 사용자 상세 조회
    @GetMapping("/detail")
    public String detail(@RequestParam String userId, Model model) {
        UserDTO user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "user/detail"; // detail.jsp
    }

    // UPDATE - 수정 폼
    @GetMapping("/edit")
    public String edit(@RequestParam String userId, Model model) {
        UserDTO user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "user/edit"; // edit.jsp
    }

    // UPDATE - 수정 처리
    @PostMapping("/update")
    public String update(UserDTO user) {
        userService.updateUser(user);
        return "redirect:/user/detail?userId=" + user.getUserId();
    }

    // DELETE - 삭제 처리
    @GetMapping("/delete")
    public String delete(@RequestParam String userId) {
        userService.deleteUser(userId);
        return "redirect:/user/list";
    }

    // 로그인 폼
    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String userId,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        UserDTO user = userService.login(userId, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/";
        } else {
            model.addAttribute("error", "로그인 실패");
            return "user/login";
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
