package com.ssafy.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDay08MyBatisSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringDay08MyBatisSpringApplication.class, args);
		
//		for(String name : context.getBeanDefinitionNames()){
//			System.out.println(name);
//		}
	}

}
