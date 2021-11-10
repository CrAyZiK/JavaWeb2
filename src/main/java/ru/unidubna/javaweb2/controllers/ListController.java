package ru.unidubna.javaweb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.unidubna.javaweb2.dao.UserDao;
import ru.unidubna.javaweb2.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ListController {
    private final UserDao userDao;
    @Autowired
    public ListController(UserDao userDao) {
        this.userDao = userDao;
    }
    @GetMapping
    public String listController(HttpServletRequest req/*, HttpServletResponse resp*/) /*throws ServletException, IOException*/ {
        List<User> users = userDao.findAll();
        List<String> names =  users.stream().map(User::getName).collect(Collectors.toList());
        req.setAttribute("userNames", names);
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/list");
        //requestDispatcher.forward(req, resp);
        return "jsp/list";
    }
}
