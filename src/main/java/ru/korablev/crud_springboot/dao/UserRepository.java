package ru.korablev.crud_springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.korablev.crud_springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);
}
