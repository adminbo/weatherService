package com.zjkj.wxy.core.utils;

import java.util.UUID;
/**
 * 获取修改密码验证码工具类
 * @author Lenovo
 *
 */
public class UUIDUtils {
	/**
	 * 获取验证码，6位随机字母数字
	 * @return
	 */
	public static String getValCode(){
		return UUID.randomUUID().toString().substring(0, 6);//截取6位，包含字母数字
	}
	
	public static String getString(Integer i){
		return UUID.randomUUID().toString().replace("-", "").substring(0, i);
	}
	public static void main(String[] args) {
//		String valCode = getValCode();
		
		System.out.println(getString(10));
	}
}
