package ru.unidubna.javaweb2.model;

import ru.unidubna.javaweb2.entity.Auto;
import ru.unidubna.javaweb2.entity.User;

import java.util.List;

public class UserService {

    private final UserDao usersDao = new UserDao();

    public UserService() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }


}