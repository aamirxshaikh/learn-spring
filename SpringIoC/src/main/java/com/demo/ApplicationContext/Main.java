package com.demo.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
	    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Device device1 = (Device) applicationContext.getBean("device1");
        Device device2 = (Device) applicationContext.getBean("device2");

        System.out.println("ApplicationContext : " + device1 + " " + device2);

        applicationContext.close();
	}
}
