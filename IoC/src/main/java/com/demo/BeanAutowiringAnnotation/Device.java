package com.demo.BeanAutowiringAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Device {
    private String series;
    private String operatingSystem;

    private Ram ram;

    public Device() {
        System.out.println("Default constructor");
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Ram getRam() {
        return ram;
    }

    @Autowired(required = false)
    @Qualifier("ramBean2")
    public void setRam(Ram ram) {
        this.ram = ram;

        System.out.println("RAM Setter");
    }

    public Device(String series, String operatingSystem, Ram ram) {
        this.series = series;
        this.operatingSystem = operatingSystem;
        this.ram = ram;

        System.out.println("Parametrized constructor");
    }

    @Override
    public String toString() {
        return "Device{" +
                "series='" + series + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", ram=" + ram +
                '}';
    }
}
