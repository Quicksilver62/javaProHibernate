package ru.vtb.java.pro.javaprohibernate.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vtb.java.pro.javaprohibernate.dao.UserDao;
import ru.vtb.java.pro.javaprohibernate.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User createUser(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        User user = new User();
        user.setUsername(username);
        return userDao.save(user);
    }

    public User findUserById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id '" + id + "' not found"));
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public void deleteUser(Long id) {
        userDao.delete(id);
    }
}
