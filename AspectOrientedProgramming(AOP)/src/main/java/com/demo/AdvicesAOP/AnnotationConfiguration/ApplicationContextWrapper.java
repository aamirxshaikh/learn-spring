package com.demo.AdvicesAOP.AnnotationConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextWrapper {
    private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

    private ApplicationContextWrapper() {}

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
