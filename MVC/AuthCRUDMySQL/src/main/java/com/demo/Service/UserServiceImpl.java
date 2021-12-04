package com.demo.Service;

import com.demo.DAO.UserDAO;
import com.demo.Model.Login;
import com.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    public UserDAO userDAO;

    @Override
    public boolean register(User user) {
        return userDAO.register(user);
    }

    @Override
    public User validateUser(Login login) {
        return userDAO.validateUser(login);
    }

    @Override
    public boolean doesEmailExist(String email) {
        return userDAO.doesEmailExist(email);
    }

    @Override
    public boolean doesIdExist(Integer id) {
        return userDAO.doesIdExist(id);
    }
}
