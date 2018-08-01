package com.biyouche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.biyouche.springboot.SpringContext;

/**
 * springboot启动类
 * @author lgh
 *
 */
@EnableTransactionManagement
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		
		SpringApplication application = new SpringApplication(SpringbootApplication.class);
		application.addListeners(new SpringContext());
		application.run(args);

	}
	
}
