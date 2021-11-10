package ru.unidubna.javaweb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.unidubna.javaweb2.model.User;
import ru.unidubna.javaweb2.dao.UserDao;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddController {

    private final UserDao userDao;
    @Autowired
    public AddController(UserDao userDao) {
        this.userDao = userDao;
    }
    @GetMapping
    public String addControllerGet()  { return "jsp/add"; }

    @PostMapping
    public String addControllerPost(HttpServletRequest req){
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User(name, age);
        userDao.save(user);
        return "redirect:jsp/add";
    }
}
