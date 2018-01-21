package com.gosling.scheduler.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SecondScheduledJob extends QuartzJobBean  {

	@Override  
    protected void executeInternal(JobExecutionContext arg0)  
            throws JobExecutionException {  
        System.out.println("I am SecondScheduledJob");  
  
    }  
	
}
