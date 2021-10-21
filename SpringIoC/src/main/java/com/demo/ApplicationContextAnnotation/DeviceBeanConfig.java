package com.demo.ApplicationContextAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceBeanConfig {
    @Bean(name = "device1", initMethod = "initBean", destroyMethod = "destroyBean")
    public Device DeviceBeanOne() {
        return new Device();
    }

    @Bean(name = "device2", initMethod = "initBean", destroyMethod = "destroyBean")
    public Device DeviceBeanTwo() {
        return new Device();
    }
}
