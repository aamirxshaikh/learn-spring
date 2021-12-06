package com.demo.Controller;

import com.demo.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/events")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping
    public String events(Model model) {
        model.addAttribute("events", eventService.getEvents());

        return "events";
    }
}
