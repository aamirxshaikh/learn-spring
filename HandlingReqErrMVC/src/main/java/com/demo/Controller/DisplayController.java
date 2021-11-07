package com.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index_page";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "test_page";
    }
}
