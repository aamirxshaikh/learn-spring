package com.demo.BeanAutowiringAnnotation;

public class Ram {
    private int pins;
    private String brand;
    private String ramType;
    private String  memory;
    private String memorySpeed;

    public Ram() {

    }

    public Ram(int pins, String brand, String ramType, String memory, String memorySpeed) {
        this.pins = pins;
        this.brand = brand;
        this.ramType = ramType;
        this.memory = memory;
        this.memorySpeed = memorySpeed;
    }

    public int getPins() {
        return pins;
    }

    public void setPins(int pins) {
        this.pins = pins;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String  brand) {
        this.brand = brand;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemorySpeed() {
        return memorySpeed;
    }

    public void setMemorySpeed(String memorySpeed) {
        this.memorySpeed = memorySpeed;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "pins=" + pins +
                ", brand=" + brand +
                ", ramType='" + ramType + '\'' +
                ", memory='" + memory + '\'' +
                ", memorySpeed='" + memorySpeed + '\'' +
                '}';
    }
}
