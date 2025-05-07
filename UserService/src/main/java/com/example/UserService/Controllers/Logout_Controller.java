package com.example.UserService.Controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Logout_Controller {

    @PostMapping("/logout")
    public ResponseEntity<String> Logout_User(HttpServletResponse response) {
            Cookie cookie = new Cookie("userId", null);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            return ResponseEntity.ok("Logged out successfully");
    }
}
