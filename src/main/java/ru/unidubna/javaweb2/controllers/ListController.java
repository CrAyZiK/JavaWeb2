package ru.unidubna.javaweb2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.unidubna.javaweb2.model.User;
import ru.unidubna.javaweb2.model.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ListController {
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public /*String*/ void listController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> users = userService.findAllUsers();
        List<String> names =  users.stream().map(User::getName).collect(Collectors.toList());
        req.setAttribute("userNames", names);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/list");
        requestDispatcher.forward(req, resp);
//        return "forward:jsp/list";
    }
}
