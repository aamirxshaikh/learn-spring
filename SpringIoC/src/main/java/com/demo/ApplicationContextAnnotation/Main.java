package com.demo.ApplicationContextAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
	    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DeviceBeanConfig.class);

	    Device device1 = (Device) applicationContext.getBean("device1");
		Device device2 = (Device) applicationContext.getBean("device2");

		device1.setId(1);
	    device1.setDevice("Device 1");
	    device1.setDescription("Description 1");

		device2.setId(2);
		device2.setDevice("Device 2");
		device2.setDescription("Description 2");

		System.out.println("Device : " + device1 + " " + device2);

		applicationContext.close();
	}
}
