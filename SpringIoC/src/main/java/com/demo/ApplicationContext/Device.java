package com.demo.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Device {
    private int id;
    private String device;
    private String description;

    Device() {
        System.out.println("Object created");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", device='" + device + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @PostConstruct
    public  void initBean() throws Exception {
        System.out.println("initBean()");
    }

    @PreDestroy
    public void destroyBean() throws Exception {
        System.out.println("destroyBean()");
    }
}
