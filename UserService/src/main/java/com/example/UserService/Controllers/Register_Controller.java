package com.example.UserService.Controllers;

import com.example.se2project.Models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Register_Controller {

    final private Register_Service register_service ;
    public Register_Controller(Register_Service register_service) {
        this.register_service = register_service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> RegisterUser(@RequestBody User user) {
        ResponseEntity<String> result = register_service.Register(user);
        return result;
    }
}
