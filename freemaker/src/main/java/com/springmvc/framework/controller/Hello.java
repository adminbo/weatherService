package com.springmvc.framework.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

	@RequestMapping("/hello")
	public String hello(Model model){
		model.addAttribute("obj","framework");
		return "hello";
	}
	@RequestMapping("/list")
	public String list(Model model){
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		model.addAttribute("obj",list);
		return "list";
	}
	@RequestMapping("/map")
	public String map(Model model){
		Map<String,String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		map.put("key5", "value5");
		model.addAttribute("obj",map);
		return "map";
	}
}
