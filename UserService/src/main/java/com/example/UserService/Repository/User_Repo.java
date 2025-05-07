package com.example.UserService.Repository;
import com.example.se2project.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface User_Repo extends JpaRepository<User,Integer> {
    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);
}