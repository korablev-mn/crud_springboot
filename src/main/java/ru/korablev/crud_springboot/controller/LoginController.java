package ru.korablev.crud_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.korablev.crud_springboot.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String ShowLogin() {
        return "login-form";
    }
    @PostMapping(value = "/login")
    public String Login() {
        return "redirect:/";
    }

    @PostMapping(value = "/logout")
    public String Logout(
            HttpSession session,
            Model model) {
        session.removeAttribute("password");
        session.removeAttribute("login");
        session.removeAttribute("role");
        session.setAttribute("inOut", "Login");
        session.setAttribute("role", "user");
        session.setAttribute("status", "user");
        model.addAttribute("inOut", "Login");
        return "redirect:/";
    }
}
