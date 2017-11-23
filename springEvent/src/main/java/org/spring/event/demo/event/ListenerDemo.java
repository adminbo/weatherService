package org.spring.event.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class ListenerDemo implements ApplicationListener<EventDemo>{

	@Override
	public void onApplicationEvent(EventDemo e) {
		// TODO Auto-generated method stub
		e.toChar();
	}

}
