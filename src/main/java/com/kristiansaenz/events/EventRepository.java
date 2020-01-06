package com.kristiansaenz.events;

import com.kristiansaenz.events.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String>{

    List<Event> findAll();

    Optional<Event> findEventById(String id);

    Event save(Event event);

    Event findEventByName(String name);

}
