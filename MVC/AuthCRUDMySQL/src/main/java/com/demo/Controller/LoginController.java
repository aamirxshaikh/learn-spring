package com.demo.Controller;

import com.demo.Model.Login;
import com.demo.Model.User;
import com.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("login");

        modelAndView.addObject("login", new Login());

        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login, Model model) {
        ModelAndView modelAndView = null;

        User user = userService.validateUser(login);

        if(user != null) {
            model.addAttribute("user", user);

            modelAndView = new ModelAndView("dashboard");
        } else {
            modelAndView = new ModelAndView("login");

            modelAndView.addObject("message", "ID or Password is incorrect. Please try again !");
        }

        return modelAndView;
    }
}
