package com.weather.core.controller;

import java.util.List;

//import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.WebXml.GetWeatherbyCityName;
import cn.com.WebXml.WeatherWebService;
import cn.com.WebXml.WeatherWebServiceLocator;
import cn.com.WebXml.WeatherWebServiceSoap;
import cn.com.WebXml.WeatherWebServiceSoapImpl;


/**
 * 天气预报服务
 * @author Lenovo
 *
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {
	private WeatherWebService weatherWebService = new WeatherWebServiceLocator();
	
	@RequestMapping("/queryByCityName")
	@ResponseBody
	public String[] getWeatherByCityName(String cityName) throws Exception{
		WeatherWebServiceSoap weatherWebServiceSoap = weatherWebService.getWeatherWebServiceSoap();
		String[] weatherbyCityName = weatherWebServiceSoap.getWeatherbyCityName(cityName);
		for (String string : weatherbyCityName) {
			System.out.println(string);
			
		}
		return weatherbyCityName;
	}
	
	public static void main(String[] args) throws Exception {
		new WeatherController().getWeatherByCityName("北京");
	}
	
}
