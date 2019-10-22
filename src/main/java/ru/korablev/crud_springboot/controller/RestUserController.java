package ru.korablev.crud_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.korablev.crud_springboot.model.User;
import ru.korablev.crud_springboot.service.RoleService;
import ru.korablev.crud_springboot.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        User user = userService.findById(id);
        if(user == null){
            throw new RuntimeException("User is not found - " + id);
        }
        return user;
    }

    @GetMapping("/users/login={login}")
    public User getUserByLogin(@PathVariable String login){
        User user = userService.getUserByLogin(login);
        if(user == null){
            throw new RuntimeException("User is not found - " + login);
        }
        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setId(0L);
        userService.save(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        User user = userService.findById(id);
        if(user ==null){
            throw new RuntimeException("User is not found - " + id);
        }
        userService.deleteById(id);
        return "Deleted user id - " + id;
    }
}