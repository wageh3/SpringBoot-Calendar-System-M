package com.example.UserService.Services;

import com.example.se2project.Models.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class Login_Service {

    final private Login_Repo login_repo ;
    public Login_Service(Login_Repo login_repo) {
        this.login_repo = login_repo;
    }

    public ResponseEntity<String> login(@RequestBody User user, HttpServletResponse response) {
        Optional<User> result = login_repo.findByEmail(user.getEmail());

        if (result.isPresent()) {
            User getted_user = result.get();
            if (getted_user.getPassword().equals(user.getPassword())) {
                Cookie userIdCookie = new Cookie("userId", getted_user.getId().toString());
                userIdCookie.setPath("/");
                userIdCookie.setHttpOnly(true);
                userIdCookie.setMaxAge(24 * 60 * 60);
                response.addCookie(userIdCookie);
                Cookie userNameCookie = new Cookie("userName", getted_user.getUsername());
                userNameCookie.setPath("/");
                userNameCookie.setHttpOnly(false);
                userNameCookie.setMaxAge(24 * 60 * 60);
                response.addCookie(userNameCookie);
                return ResponseEntity.ok("SUCCESS");
            }
            else {
                return ResponseEntity.ok("WRONG PASSWORD");
            }
        }
        else {
            return ResponseEntity.ok("THIS EMAIL NOT FOUND");
        }
    }

}
