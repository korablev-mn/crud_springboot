package ru.korablev.crud_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.korablev.crud_springboot.dao.UserRepository;
import ru.korablev.crud_springboot.model.Role;
import ru.korablev.crud_springboot.model.User;
import ru.korablev.crud_springboot.service.RoleService;
import ru.korablev.crud_springboot.service.UserService;
import ru.korablev.crud_springboot.util.ListRoles;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/home")
    public String home(
            Model model,
            @ModelAttribute("theUser") User user,
            Principal login) {
        List<User> userList = new ArrayList<>();
        userList = userService.findAll();
        model.addAttribute("list", userList);
        ListRoles roles = new ListRoles();
        model.addAttribute("listRole", roles.getListRole());
        return "home";
    }

//    @GetMapping("/admin")
//    public String viewAllUsers(
//            Model model,
//            Principal login) {
//        List<User> userList = new ArrayList<>();
//        try {
//            userList = userService.findAll();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("list", userList);
//        return "users";
//    }

//    @GetMapping("/admin/showFormForAdd")
//    public String showFormForAdd(Model theModel) {
//
//        User theUser = new User();
//        theModel.addAttribute("theUser", theUser);
//        return "/user-form";
//    }
//
    @GetMapping("/admin/showFormForUpdate")
    public String showFormForUpdate(
            @RequestParam("userId") Long theId,
            Model theModel) {
//        User theUser = userService.findById(theId);
//        theModel.addAttribute("theUser", theUser);
        return "redirect:/home";
    }

    @PostMapping("/admin/save")
    public String saveEmployee(
            @RequestParam(value = "role") String role,
            @ModelAttribute("theUser") User user
           ) {
        try {
            Set<Role> roles = new HashSet<Role>();
            Role roleUser = roleService.findByRole(role);
            roles.add(roleUser);
            user.setRoles(roles);
            userService.save(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }


//    @GetMapping("/admin/delete")
//    public String delete(@RequestParam("userId") Long theId) {
//
//        try {
//            userService.deleteById(theId);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/admin";
//    }

//    @GetMapping(value = "/user")
//    public String personalPage(
//            Principal profile,
//            Model model) {
//        String login = profile.getName();
//        User user = userService.getUserByLogin(login);
//        List<User> list = new ArrayList<>();
//        list.add(user);
//        model.addAttribute("list", list);
//        return "users";
//    }
}