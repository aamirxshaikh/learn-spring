package com.demo.BeanDefinitionRegistry;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");

        DefaultListableBeanFactory beanDefinitionRegistry = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);

        xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        Device device = (Device) (beanDefinitionRegistry).getBean("device");

        System.out.println("BeanDefinitionRegistry : " + device);
    }
}
