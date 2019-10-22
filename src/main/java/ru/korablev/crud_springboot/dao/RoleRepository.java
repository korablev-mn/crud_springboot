package ru.korablev.crud_springboot.dao;

import ru.korablev.crud_springboot.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleRepository {
    Role findByRole(String role);

    List<Role> findAll();
}

