package com.weather.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
//
//@Configuration
//@EnableWebMvc
public class WebMvcConfig {
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/classes/jsp");
		ir.setSuffix(".jsp");
		ir.setViewClass(JstlView.class);
		return ir;
	}
}
