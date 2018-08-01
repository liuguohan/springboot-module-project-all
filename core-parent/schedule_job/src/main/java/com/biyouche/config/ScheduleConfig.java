package com.biyouche.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 定时任务配置
 * @author lgh
 *
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer, AsyncConfigurer{
 
	@Value("${poolSize}")
	public int poolSize;
	
	@Value("${threadNamePrefix}")
	public String threadNamePrefix;
	
	@Value("${awaitTerminationSeconds}")
	public int awaitTerminationSeconds;
	
	@Value("${waitForTasksToCompleteOnShutdown}")
	public boolean waitForTasksToCompleteOnShutdown;
	
	/** 异步处理 */
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar){
		TaskScheduler taskScheduler = taskScheduler();
		taskRegistrar.setTaskScheduler(taskScheduler);
	}
 
	/** 定时任务多线程处理 */
	@Bean(destroyMethod = "shutdown")
	public ThreadPoolTaskScheduler taskScheduler(){
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(poolSize);
		scheduler.setThreadNamePrefix(threadNamePrefix);
		scheduler.setAwaitTerminationSeconds(awaitTerminationSeconds);
		scheduler.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
		return scheduler;
	}
 
	/** 异步处理 */
	public Executor getAsyncExecutor(){
		Executor executor = taskScheduler();
		return executor;
	}
 
	/** 异步处理 异常 */
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
		return new SimpleAsyncUncaughtExceptionHandler();
	}
	
}
