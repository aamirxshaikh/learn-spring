package com.demo.ApplicationContextAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
	    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DeviceBeanConfig.class);

	    Device device = (Device) applicationContext.getBean("DeviceBean");

	    device.setId(1);
	    device.setDevice("Device 1");
	    device.setDescription("Description 1");

	    System.out.println("Device : " + device);
	}
}
