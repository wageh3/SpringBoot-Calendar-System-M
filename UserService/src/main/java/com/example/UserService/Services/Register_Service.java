package com.example.UserService.Services;

import com.example.se2project.Models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class Register_Service {

    final private Register_Repo register_repo ;
    public Register_Service(Register_Repo register_repo) {
        this.register_repo = register_repo;
    }

    public ResponseEntity<String> Register(@RequestBody User user) {
        Optional<User> result = register_repo.findByEmail(user.getEmail());

        if (result.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)  // 409 Conflict
                    .body("This Email Is Already Exist: " + user.getEmail());
        }
        else {
            register_repo.save(user);
            return ResponseEntity
                    .status(HttpStatus.CREATED)  // 201 Created
                    .body("User Registered Successfully");
        }
    }

}
