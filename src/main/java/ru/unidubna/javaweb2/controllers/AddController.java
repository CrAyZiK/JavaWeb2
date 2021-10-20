package ru.unidubna.javaweb2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.unidubna.javaweb2.entity.User;
import ru.unidubna.javaweb2.model.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addControllerGet()  { return "jsp/add"; }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addControllerPost(HttpServletRequest req){
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User(name, age);
        UserService userService = new UserService();
        userService.saveUser(user);
        return "jsp/add";
    }
}
