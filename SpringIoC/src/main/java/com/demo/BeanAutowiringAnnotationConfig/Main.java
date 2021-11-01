package com.demo.BeanAutowiringAnnotationConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DeviceBeanConfig.class);

        Device device = (Device) applicationContext.getBean("deviceBean");

        System.out.println(device);
    }
}
