package com.demo.Model;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Please Enter Name")
    private String name;

    private String details;

    @NotEmpty(message = "Please Enter Location")
    private String location;

    public Event() {
    }

    public Event(Integer id, String name, String details, String location) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
