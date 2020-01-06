package com.kristiansaenz.events.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "Events")
public class Event {

    @Id
    private String id;

    private String name;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date date;

    private String address;

    public Event() {}

    public Event(String id, String name, Date date, String address) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
