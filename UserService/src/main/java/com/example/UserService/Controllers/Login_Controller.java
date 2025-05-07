package com.example.UserService.Controllers;

import com.example.se2project.Models.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Login_Controller {

    final private Login_Service login_service ;
    public Login_Controller(Login_Service login_service) {
        this.login_service = login_service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user, HttpServletResponse response) {
        ResponseEntity<String> result = login_service.login(user,response);
        return result;
    }



}
