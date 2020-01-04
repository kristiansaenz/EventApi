package com.kristiansaenz.events.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Event {
    @Id
    private String id;
    private String name;
    private Date date;
    private String address;

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
