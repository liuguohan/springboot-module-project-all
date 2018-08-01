package com.biyouche;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 定时任务启动类
 * @author lgh
 *
 */
@EnableAsync
@SpringBootApplication
@MapperScan("com.biyouche.dao")
public class JobApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}
	
}