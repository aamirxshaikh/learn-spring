package com.demo.BeanAutowiringMultipleDependencies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceBeanConfig {
    @Bean
    public Device deviceBean() {
        Device device = new Device();

        device.setSeries("400");
        device.setOperatingSystem("Ubuntu");

        return device;
    }

    @Bean(name = "ramBean8GB")
    public Ram ram() {
        return new Ram(900, "Intel", "DDR4", "8GB", "4.05 GHz");
    }
}
