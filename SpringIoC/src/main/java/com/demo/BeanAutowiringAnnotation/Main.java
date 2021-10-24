package com.demo.BeanAutowiringAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("beanAutowiringAnnotation.xml");

        Device device = (Device) appletContext.getBean("deviceBean");

        System.out.println(device);
    }
}
