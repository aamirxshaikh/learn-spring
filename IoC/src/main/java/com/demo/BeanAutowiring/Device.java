package com.demo.BeanAutowiring;

public class Device {
    private String series;
    private String operatingSystem;
    private Ram ram;

    public Device() {
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

    public void setRam(Ram ram) {
        this.ram = ram;
    }

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
