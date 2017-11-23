package org.spring.event.demo.event;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class PublisherDemo {
	@Resource
	ApplicationContext applicationContext;
	
	public void publish(String msg){
		applicationContext.publishEvent(new EventDemo(this, msg));
	}
}
