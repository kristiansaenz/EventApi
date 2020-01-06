package com.kristiansaenz.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kristiansaenz.events.models.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventRepository eventRepository;

    @Test
    public void getAllEvents() throws Exception {
        List<Event> eventList = new ArrayList<Event>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date1 = formatter.parse("25/01/2020 13:30:00");
        Date date2 = formatter.parse("25/02/2020 10:30:00");

        Event event1 = new Event("1", "Hiking Retreat", null, "1234 Hood Drive");
        eventList.add(event1);

        Event event2 = new Event("2", "Yoga Getaway", null, "1234 Boulder Drive");
        eventList.add(event2);

        given(eventRepository.findAll()).willReturn(eventList);

        this.mockMvc.perform(get("/events/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': '1', 'name': 'Hiking Retreat','date': null, 'address': '1234 Hood Drive'}," +
                        "{'id': '2', 'name': 'Yoga Getaway','date': null, 'address': '1234 Boulder Drive'}]"));
    }

    @Test
    public void getEventById() throws Exception{

        String dateAsString = "25/01/2020 01:30:00";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = formatter.parse(dateAsString);

        Event event = new Event("1", "Hiking Retreat", null, "1234 Hood Drive");

        given(eventRepository.findEventById(event.getId())).willReturn(Optional.of(event));

        this.mockMvc.perform(get("/events/" + event.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': '1', 'name': 'Hiking Retreat','date': null, 'address': '1234 Hood Drive'}"));
    }

    @Test
    public void createEvent() throws Exception {

        String dateAsString = "15/01/2020 06:00:00";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = formatter.parse(dateAsString);

        Event event = new Event("1", "Sledding Class", date, "1234 Hood Drive");

        given(eventRepository.save(event)).willReturn(event);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObject = objectMapper.writeValueAsString(event);

        this.mockMvc.perform(post("/events/create").content(jsonObject).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();


    }

}