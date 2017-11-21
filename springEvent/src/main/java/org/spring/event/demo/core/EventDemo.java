package org.spring.event.demo.core;

import org.springframework.context.ApplicationEvent;

public class EventDemo extends ApplicationEvent{
	private String msg;
	public EventDemo(Object source,String msg) {
		super(source);
		// TODO Auto-generated constructor stub
		this.msg=msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void toChar(){
		String s=msg;
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			System.out.println(c);
		}
	}
	
}
