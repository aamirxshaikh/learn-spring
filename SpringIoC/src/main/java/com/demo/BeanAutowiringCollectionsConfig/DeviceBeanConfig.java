package com.demo.BeanAutowiringCollectionsConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DeviceBeanConfig {
    @Bean
    public Device deviceBean() {
        Device device = new Device();

        ArrayList<String> info = new ArrayList<>();

        info.add("Sample Info");
        info.add("Sample Info");

        device.setSeries("200");
        device.setOperatingSystem("Windows 11");
        device.setInfo(info);

        return device;
    }

    @Bean
    public Ram ramBean() {
        return new Ram(900, "Intel", "DDR4", "8GB", "4.05 GHz");
    }

    @Bean
    public Processor processorBean() {
        Processor processor = new Processor();

        processor.setName("Intel");
        processor.setCpuClock("3x");
        processor.setCacheSpeed("Core");

        return processor;
    }

    @Bean
    public Hdd hdd500GB() {
        Hdd hdd = new Hdd();

        hdd.setStorageCapacity("500 GB");
        hdd.setHddInterface("USB 3.0");
        hdd.setBrand("Seagate");

        return hdd;
    }

    @Bean
    public Hdd hdd1TB() {
        Hdd hdd = new Hdd();

        hdd.setStorageCapacity("1 TB");
        hdd.setHddInterface("USB 3.0");
        hdd.setBrand("Seagate");

        return hdd;
    }

    @Bean
    public Hdd hdd2TB() {
        Hdd hdd = new Hdd();

        hdd.setStorageCapacity("2 TB");
        hdd.setHddInterface("USB 3.0");
        hdd.setBrand("Seagate");

        return hdd;
    }
}
