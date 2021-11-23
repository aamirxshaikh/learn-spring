package com.demo.Registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class RegistrationController {
    @RequestMapping("/register")
    public String register(Model model) {
        Registration registration = new Registration();

        model.addAttribute("registration", registration);

        return "registration";
    }

    @RequestMapping("/submit")
    public String submit(@ModelAttribute("registration") Registration registration) {
        return "confirmation";
    }
}
