package ru.korablev.crud_springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korablev.crud_springboot.dao.UserRepository;
import ru.korablev.crud_springboot.model.User;
import ru.korablev.crud_springboot.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long theId) {
        Optional<User> result = userRepository.findById(theId);
        User user = null;

        if (result.isPresent()) {
            user = result.get();
        }
        else {
            throw new RuntimeException("Did not find user id - " + theId);
        }
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long theId) {
        userRepository.deleteById(theId);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}
