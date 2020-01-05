package com.kristiansaenz.events;

import com.kristiansaenz.events.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String>{

    List<Event> findAll();

//    Event findById(String id);

    Event save(Event event);

}
