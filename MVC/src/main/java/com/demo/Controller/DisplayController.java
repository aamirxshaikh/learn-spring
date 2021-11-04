package com.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisplayController {
    @RequestMapping(value = "/index")
    public ModelAndView index(Model model) {
        model.addAttribute("message", "index");

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/test")
    public ModelAndView test(Model model) {
        model.addAttribute("message","test");

        return new ModelAndView("index");
    }
}
