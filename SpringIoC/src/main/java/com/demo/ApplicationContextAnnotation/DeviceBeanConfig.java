package com.demo.ApplicationContextAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceBeanConfig {
    @Bean(name = "device1", initMethod = "initBean", destroyMethod = "destroyBean")
    public Device DeviceBeanOne() {
        Device device = new Device();

        device.setId(1);
        device.setDevice("Device 1");
        device.setDescription("Description 1");

        return device;
    }

    @Bean(name = "device2", initMethod = "initBean", destroyMethod = "destroyBean")
    public Device DeviceBeanTwo() {
        Device device = new Device();

        device.setId(2);
        device.setDevice("Device 2");
        device.setDescription("Description 2");

        return device;
    }
}
