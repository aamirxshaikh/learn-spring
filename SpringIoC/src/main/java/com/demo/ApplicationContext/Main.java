package com.demo.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
	    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Device device1 = (Device) applicationContext.getBean("device1");
        Device device2 = (Device) applicationContext.getBean("device2");

        device1.setId(1);
        device1.setDevice("Device 1");
        device1.setDescription("Description 1");

        device2.setId(2);
        device2.setDevice("Device 2");
        device2.setDescription("Description 2");

        System.out.println("ApplicationContext : " + device1 + " " + device2);

        applicationContext.close();
	}
}
