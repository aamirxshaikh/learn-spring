package com.demo.Service;

import com.demo.Model.Login;
import com.demo.Model.User;

public interface UserService {
    boolean register(User user);

    User validateUser(Login login);

    boolean doesEmailExist(String email);

    boolean doesIdExist(Integer id);
}
