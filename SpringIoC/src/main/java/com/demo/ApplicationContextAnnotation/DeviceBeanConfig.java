package com.demo.ApplicationContextAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.demo")
public class DeviceBeanConfig {
}
