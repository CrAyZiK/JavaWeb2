package ru.unidubna.javaweb2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.unidubna.javaweb2.model.User;
import ru.unidubna.javaweb2.model.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class AddController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addControllerGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/add");
        requestDispatcher.forward(req, resp);
        /*return "jsp/add";*/
    }

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
