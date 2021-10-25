package com.demo.BeanAutowiringCollectionsConfig;

public class Processor {
    private String name;
    private String cpuClock;
    private String cacheSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpuClock() {
        return cpuClock;
    }

    public void setCpuClock(String cpuClock) {
        this.cpuClock = cpuClock;
    }

    public String getCacheSpeed() {
        return cacheSpeed;
    }

    public void setCacheSpeed(String cacheSpeed) {
        this.cacheSpeed = cacheSpeed;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "name='" + name + '\'' +
                ", cpuClock='" + cpuClock + '\'' +
                ", cacheSpeed='" + cacheSpeed + '\'' +
                '}';
    }
}
