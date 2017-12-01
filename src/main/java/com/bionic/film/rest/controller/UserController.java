package com.bionic.film.rest.controller;

import com.bionic.film.dao.UserDao;
import com.bionic.film.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "user") // This means URL's start with /demo (after Application path)
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewUser(@RequestParam String email
            , @RequestParam String password) {

        User newUser = new User();

        newUser.setEmail(email);
        newUser.setPassword(password);
        userDao.save(newUser);
        return "redirect:all";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userDao.findAll();
    }
}


