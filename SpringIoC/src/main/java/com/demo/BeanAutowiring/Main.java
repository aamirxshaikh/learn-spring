package com.demo.BeanAutowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("beanAutowiring.xml");

        Device device = (Device) appletContext.getBean("deviceBean");

        System.out.println(device);
    }
}
