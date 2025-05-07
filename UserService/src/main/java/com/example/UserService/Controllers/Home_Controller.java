package com.example.UserService.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home_Controller {
    @GetMapping("/")
    public String hello() {
        return "welcome.html";
    }
}
