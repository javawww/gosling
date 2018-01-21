package com.gosling.scheduler.jobs;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String args[]){  
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config/spring-quartz-task.xml");  
    }  
	
}
