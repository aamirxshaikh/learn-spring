package com.demo.AdvicesAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextWrapper {
    private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AdvicesAOP/applicationContextXml.xml");

    private ApplicationContextWrapper() {}

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
