package ru.korablev.crud_springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.korablev.crud_springboot.model.Role;

public interface RoleRepository {
    Role findByRole(String role);
}

