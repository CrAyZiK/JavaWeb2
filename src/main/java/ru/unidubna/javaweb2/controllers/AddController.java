package ru.unidubna.javaweb2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.unidubna.javaweb2.model.User;
import ru.unidubna.javaweb2.dao.UserDao;

import javax.validation.Valid;

@Controller
@RequestMapping("add")
public class AddController {

    private final UserDao userDAO;
    @Autowired
    public AddController(UserDao userDao) {
        this.userDAO = userDao;
    }
    @GetMapping
    public String addControllerGet()  { return "jsp/add"; }

    @PostMapping
    public String addControllerPost(@ModelAttribute("user") @Valid User user,
                                    BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "jsp/index";
        }
        userDAO.save(user);
        return "redirect:/add";
    }
}
