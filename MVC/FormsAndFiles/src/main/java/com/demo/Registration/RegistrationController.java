package com.demo.Registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@Controller
public class RegistrationController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        Registration registration = new Registration();

        model.addAttribute("registration", registration);

        List<String> interest = new ArrayList<>();

        interest.add("Full Stack Development");
        interest.add("AI/ML");
        interest.add("Big Data");

        model.addAttribute("interest", interest);

        return "registration";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("registration") Registration registration, BindingResult result, Model model) {
        List<String> interest = new ArrayList<>();

        interest.add("Full Stack Development");
        interest.add("AI/ML");
        interest.add("Big Data");

        model.addAttribute("interest", interest);

        if(result.hasErrors()) {
            return "registration";
        } else {
            return "confirmation";
        }
    }
}
