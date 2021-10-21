package com.demo.ApplicationContextAnnotation;

import org.springframework.stereotype.Component;

@Component
public class Device {
    private int id;
    private String device;
    private String description;

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
}
