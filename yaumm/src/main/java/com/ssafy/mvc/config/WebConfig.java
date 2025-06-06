package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.intercepter.AdminIntercepter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	AdminIntercepter adminIntercepter;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminIntercepter).addPathPatterns("/users");
	}
}