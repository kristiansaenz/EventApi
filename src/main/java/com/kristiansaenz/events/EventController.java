package com.kristiansaenz.events;

import com.kristiansaenz.events.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getEventById() {
        return "Get event by id";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Event createEvent(@RequestBody Event event){

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        event.setId(id);

        //create date object or format date

        eventRepository.save(event);
        return event;
    }
}
