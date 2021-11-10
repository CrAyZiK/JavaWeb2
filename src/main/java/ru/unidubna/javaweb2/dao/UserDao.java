package ru.unidubna.javaweb2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.unidubna.javaweb2.model.User;
import ru.unidubna.javaweb2.rep.UserRepository;

import java.util.List;

@Component
public class UserDao {

    private final UserRepository userRepository;

    @Autowired
    public UserDao(UserRepository ur) {
        this.userRepository = ur;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }


    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        List<User> users = (List<User>)userRepository.findAll();
        return users;
    }
}