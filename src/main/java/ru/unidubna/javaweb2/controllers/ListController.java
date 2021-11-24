package ru.unidubna.javaweb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.unidubna.javaweb2.dao.UserDao;
import ru.unidubna.javaweb2.model.User;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("list")
public class ListController {
    private final UserDao userDAO;
    @Autowired
    public ListController(UserDao userDao) { this.userDAO = userDao; }

    @GetMapping
    public String listController(@ModelAttribute("userNames") @Valid String name,
                                 BindingResult bindingResult, Model model)  {
        List<User> users = userDAO.findAll();
        List<String> names =  users.stream().map(User::getName).collect(Collectors.toList());
        model.addAttribute("userNames", names);
        return "jsp/list";
    }
}
