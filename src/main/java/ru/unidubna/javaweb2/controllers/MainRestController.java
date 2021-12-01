package ru.unidubna.javaweb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.unidubna.javaweb2.dao.UserDao;
import ru.unidubna.javaweb2.model.User;

import java.util.List;

@RestController
@RequestMapping("index")
public class MainRestController{
    @Autowired
    private final UserDao userDAO;
    public MainRestController(UserDao userDao) {
        this.userDAO = userDao;
    }
    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        userDAO.save(user);
    }

    @GetMapping("/findAll")
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }
}
