package com.biyouche;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biyouche.springboot.SpringContext;

@SpringBootApplication
@MapperScan("com.biyouche.dao")
public class ApplyApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ApplyApplication.class);
		application.addListeners(new SpringContext());
		application.run(args);
	}
	
}
