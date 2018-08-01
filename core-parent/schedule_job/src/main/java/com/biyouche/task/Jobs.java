package com.biyouche.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author lgh
 *
 */
@Async
@Component
public class Jobs {

	private final static Logger LOGGER = LoggerFactory.getLogger(Jobs.class);
	
	//表示方法执行完成后5秒
    @Scheduled(fixedDelay=5000)
    public void fixedDelayJob() throws InterruptedException{  
    	LOGGER.info("fixedDelay 每隔5秒"+new Date());
    }
    
    //表示每隔3秒
    @Scheduled(fixedRate=3000)
    public void fixedRateJob(){
        
    	LOGGER.info("fixedRate 每隔3秒"+new Date());
    }

    //表示每天3时15分0秒执行
    @Scheduled(cron="0 15 3 * * ?")
    public void cronJob(){
    	LOGGER.info(new Date()+" ...>>cron....");
    }
	
}
