package com.demo.AdvicesAOP;

import org.aspectj.lang.JoinPoint;

public class AspectConfig {
    public void printMethodName(JoinPoint joinPoint) {
        System.out.println("Called by : " + joinPoint.getSignature().getName());
    }
}
