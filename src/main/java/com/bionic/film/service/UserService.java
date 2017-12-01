package com.bionic.film.service;

import com.bionic.film.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long userId);

    @Transactional
    void save(User user);

    void register(String name, String email, String pass);
}
