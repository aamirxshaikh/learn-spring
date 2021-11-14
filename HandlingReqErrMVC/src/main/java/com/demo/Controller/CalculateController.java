package com.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @RequestMapping("/calculate")
    public String calculate(@RequestParam("number1") int number1, @RequestParam("number2") int number2, Model model) {
        String message = "Results for : " + number1 + " and " + number2;

        model.addAttribute("message", message);

        model.addAttribute("sum", (number1 + number2));
        model.addAttribute("subtract", (number1 - number2));
        model.addAttribute("multiply", (number1 * number2));
        model.addAttribute("divide", (number1 / number2));
        model.addAttribute("modulus", (number1 % number2));

        return "results";
    }
}
