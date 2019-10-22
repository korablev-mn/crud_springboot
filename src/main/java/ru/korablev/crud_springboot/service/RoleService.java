package ru.korablev.crud_springboot.service;

import ru.korablev.crud_springboot.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    public Role findByRole(String role);

    public List<Role> findAll();
}
