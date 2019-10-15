package ru.korablev.crud_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.korablev.crud_springboot.service.UserService;

@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String Login() {
        return "redirect:/home";
    }

    @PostMapping(value = "/logout")
    public String Logout() {
        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String start() {
        return "login";
    }
}