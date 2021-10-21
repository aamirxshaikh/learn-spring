package com.demo.ApplicationContextAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceBeanConfig {
    @Bean
    public Device DeviceBean() {
        return new Device();
    }
}
