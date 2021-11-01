package com.demo.BeanReference;

public class Device {
    private String series;
    private String operatingSystem;
    private Ram ram;

    public Device(String series, String operatingSystem, Ram ram) {
        this.series = series;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
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
