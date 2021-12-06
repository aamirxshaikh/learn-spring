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
}
