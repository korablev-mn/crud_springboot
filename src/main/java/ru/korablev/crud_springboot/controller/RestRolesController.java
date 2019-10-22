package ru.korablev.crud_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.korablev.crud_springboot.model.Role;
import ru.korablev.crud_springboot.model.User;
import ru.korablev.crud_springboot.service.RoleService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest")
public class RestRolesController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public List<Role> findAll(){
        return roleService.findAll();
    }
}
