package com.demo.Controller;

import com.demo.Model.Event;
import com.demo.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping(value = "/events")
    public String events(Model model) {
        model.addAttribute("events", eventService.getEvents());

        return "events";
    }

    @GetMapping(value = "/events/create")
    public String create(Model model) {
        model.addAttribute("event", new Event());

        return "addEvent";
    }

    @PostMapping(value = "/events/store")
    public String store(@ModelAttribute("event") Event event) {
        eventService.addEvent(event);

        return "redirect:/events";
    }
}
