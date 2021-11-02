package com.demo.BeanAutowiringCollectionsXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanAutowiringCollections.xml");

        Device device = (Device) applicationContext.getBean("deviceBean");

        System.out.println(device);
    }
}
