package ru.korablev.crud_springboot.service;

import org.springframework.stereotype.Service;
import ru.korablev.crud_springboot.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(Long theId);

    public void save(User user);

    public void deleteById(Long theId);

    User getUserByLogin(String login);
}
