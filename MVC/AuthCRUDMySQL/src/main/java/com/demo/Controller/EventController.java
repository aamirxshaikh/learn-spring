package com.demo.Controller;

import com.demo.Model.Event;
import com.demo.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("event", new Event());

        return "add";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute("event") Event event) {
        eventService.addEvent(event);

        return "redirect:/events";
    }

    @GetMapping(value = "edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Event event = eventService.getEvent(id);

        model.addAttribute("event", event);

        return "edit";
    }

    @PostMapping(value = "edit/{id}")
    public String update(@ModelAttribute("event") Event event) {
        eventService.updateEvent(event);

        return "redirect:/events";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Event event = eventService.getEvent(id);

        model.addAttribute("event", event);

        return "delete";
    }

    @PostMapping(value = "delete/{id}")
    public String destroy(@ModelAttribute("event") Event event) {
        eventService.deleteEvent(event.getId());

        return "redirect:/events";
    }
}
