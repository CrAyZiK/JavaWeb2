package ru.unidubna.javaweb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.unidubna.javaweb2.dao.UserDao;
import ru.unidubna.javaweb2.model.User;


import java.util.List;

@Controller
public class MainController {
//    @Autowired
//    private final UserDao userDAO;
//    public MainController(UserDao userDao) {
//        this.userDAO = userDao;
//    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index() {
        return "jsp/index";
    }

//    @PostMapping("/save")
//    public void saveUser(@RequestBody User user) {
//        userDAO.save(user);
//    }
//
//    @GetMapping("/findAll")
//    public List<User> findAllUsers() {
//        return userDAO.findAll();
//    }
}

