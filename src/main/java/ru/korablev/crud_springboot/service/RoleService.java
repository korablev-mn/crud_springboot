package ru.korablev.crud_springboot.service;

import ru.korablev.crud_springboot.model.Role;

public interface RoleService {

    public Role findByRole(String role);
}
