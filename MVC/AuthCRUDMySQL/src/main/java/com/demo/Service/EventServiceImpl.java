package com.demo.Service;

import com.demo.DAO.EventDAO;
import com.demo.Model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDAO eventDAO;

    @Override
    public List<Event> getEvents() {
        return eventDAO.getEvents();
    }

    @Override
    public void addEvent(Event event) {
        eventDAO.addEvent(event);
    }

    @Override
    public Event getEvent(int id) {
        return eventDAO.getEvent(id);
    }

    @Override
    public void updateEvent(Event event) {
        eventDAO.updateEvent(event);
    }

    @Override
    public void deleteEvent(int id) {
        eventDAO.deleteEvent(id);
    }
}
