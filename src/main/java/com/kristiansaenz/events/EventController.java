package com.kristiansaenz.events;

import com.kristiansaenz.events.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Event> getEventById(@PathVariable("id") String id) {
        Optional<Event> eventOptional = eventRepository.findEventById(id);

        if (!eventOptional.isPresent()) {
            System.out.println("event with id " + id + " does not exist!");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(eventOptional.get());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createEvent(@RequestBody Event event){

        // create uuid for event
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        event.setId(id);

        // check if event name is unique
        Event eventCheck = eventRepository.findEventByName(event.getName());
        Boolean isEventNameUnique = eventCheck != null ? false : true;

        if (isEventNameUnique){
            return ResponseEntity.status(HttpStatus.CREATED).body(eventRepository.save(event));
        }
        else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("name of event already exists! use another name, pls :)");
        }
    }
}
