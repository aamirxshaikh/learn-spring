package com.demo.springdatajdbccrudrepository.Conference;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table("conferences")
public class Conference {
    @Id
    @Column("id")
    private Integer conferenceId;

    @Column("name")
    private String name;

    @Column("location")
    private String location;

    @Column("capacity")
    private int capacity;

    @Column("conference_date")
    private Date date;

    public Conference(Integer conferenceId, String name, String location, int capacity, Date date) {
        this.conferenceId = conferenceId;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "conferenceId=" + conferenceId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", date=" + date +
                '}';
    }
}
