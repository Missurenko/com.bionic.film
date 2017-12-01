package com.bionic.film.service.impl;

import com.bionic.film.dao.UserDao;
import com.bionic.film.model.User;
import com.bionic.film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(long userId) {
        return userDao.findById(userId);
    }


    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void register(String name, String email, String pass) {
        if (isValidEmail(email)) {
            if (userDao.findByEmail(email) != null) {
                throw new RuntimeException("User with this email already exits!!!");
            }
            User user = new User();
            user.setEmail(email);
            user.setPassword(Arrays.toString(DigestUtils.md5Digest(pass.getBytes())));
            userDao.save(user);
        } else {
            throw new RuntimeException("Wrong email!!!");
        }
    }

    protected boolean isValidEmail(String email) {
        return true;
    }

}