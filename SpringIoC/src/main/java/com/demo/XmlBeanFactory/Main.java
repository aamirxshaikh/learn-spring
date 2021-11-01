package com.demo.XmlBeanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {
        Device constructedObject = new Device();

        System.out.println("Constructed Object : " + constructedObject);

        System.out.println();

        System.out.println("BeanFactory Container");

        Resource resource = new ClassPathResource("applicationContext.xml");

        BeanFactory beanFactory = new XmlBeanFactory(resource);

        Device beanObject = (Device) beanFactory.getBean("device");

        System.out.println("Bean Object : " + beanObject);
    }
}
