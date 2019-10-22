package ru.korablev.crud_springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korablev.crud_springboot.dao.RoleRepository;
import ru.korablev.crud_springboot.model.Role;
import ru.korablev.crud_springboot.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
