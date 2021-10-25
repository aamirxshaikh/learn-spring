package com.demo.BeanAutowiringCollectionsConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Set;

public class Device {
    private String series;
    private String operatingSystem;
    private Ram ram;
    private Processor processor;
    private Set<Hdd> availableHddOptions;
    private List<String> info;

    public Device() {
        System.out.println("Default constructor");
    }

    public Device(String series, String operatingSystem, Ram ram, Processor processor, Set<Hdd> availableHddOptions, List<String> info) {
        this.series = series;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.processor = processor;
        this.availableHddOptions = availableHddOptions;
        this.info = info;

        System.out.println("Parametrized constructor");
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
    public void setRam(Ram ram) {
        this.ram = ram;

        System.out.println("Ram Setter method");
    }

    public Processor getProcessor() {
        return processor;
    }

    @Autowired(required = false)
    public void setProcessor(Processor processor) {
        this.processor = processor;

        System.out.println("Processor Setter method");
    }

    public Set<Hdd> getAvailableHddOptions() {
        return availableHddOptions;
    }

    @Autowired(required = false)
    public void setAvailableHddOptions(Set<Hdd> availableHddOptions) {
        this.availableHddOptions = availableHddOptions;

        System.out.println("Hdd Setter method");
    }

    public List<String> getInfo() {
        return info;
    }

    @Autowired(required = false)
    public void setInfo(List<String> info) {
        this.info = info;

        System.out.println("Info Setter method");
    }

    @Override
    public String toString() {
        return "Device{" +
                "series='" + series + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", ram=" + ram +
                ", processor=" + processor +
                ", availableHddOptions=" + availableHddOptions +
                ", info=" + info +
                '}';
    }
}
