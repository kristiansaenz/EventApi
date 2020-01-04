package com.kristiansaenz.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllEvents() {
        return "Get all events";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getEventById() {
        return "Get event by id";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createEvent(){
        return "Create event";
    }
}
