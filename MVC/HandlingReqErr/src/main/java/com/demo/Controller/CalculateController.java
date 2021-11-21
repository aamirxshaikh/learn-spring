package com.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class CalculateController {
    @RequestMapping("/calculate")
    public String calculate(@RequestParam("number1") int number1, @RequestParam("number2") int number2, Model model) throws SQLException {
        if(number1 > 10) {
            throw new IllegalArgumentException("Number not valid");
        }

        if(number2 > 100) {
            throw new SQLException("Data cannot be retrieved");
        }

        String message = "Results for : " + number1 + " and " + number2;

        model.addAttribute("message", message);

        model.addAttribute("sum", (number1 + number2));
        model.addAttribute("subtract", (number1 - number2));
        model.addAttribute("multiply", (number1 * number2));
        model.addAttribute("divide", (number1 / number2));
        model.addAttribute("modulus", (number1 % number2));

        return "results";
    }

    @ExceptionHandler({IllegalArgumentException.class, SQLException.class, ArithmeticException.class})
    public ModelAndView handleExceptions(Exception exception) {
        ModelAndView model = new ModelAndView("exception");

        model.addObject("exception", exception.getMessage());

        return model;
    }
}
