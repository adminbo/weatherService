package org.spring.event.demo;

import javax.annotation.Resource;

import org.spring.event.demo.core.PublisherDemo;
import org.spring.event.demo.core.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringEventApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringEventApplication.class, args);
//		PublisherDemo demo =  new PublisherDemo();
		ApplicationContext applicationContext = SpringContextUtil.applicationContext;
		PublisherDemo bean = applicationContext.getBean(PublisherDemo.class);
		bean.publish("hello world");
	}
}
