package com.demo;

public class Device {
    private int id = 1;
    private String device = "AC";
    private String description = "Sensor";

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
