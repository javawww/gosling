package com.gosling.scheduler.jobs;

import org.springframework.stereotype.Component;

@Component("myBean")  
public class MyBean {
	public void printMessage() {  
        System.out.println("I am MyBean. I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");  
    }  
}
