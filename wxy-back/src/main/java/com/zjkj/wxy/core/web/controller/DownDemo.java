package com.zjkj.wxy.core.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjkj.wxy.core.utils.FileDownloadUtils;

@Controller
public class DownDemo {

	@RequestMapping("/downLoad")
	public ResponseEntity<byte[]> downFile(HttpServletResponse res,HttpServletRequest req){
		String realPath =  req.getRealPath("/down/新建文本文档.txt");
		File file= new File(realPath);
		try {
			return  FileDownloadUtils.download("新建文本文档.txt", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
public static void main(String[] args) {
	String da="2017-08-02";
	String d="2016-08-09";
	da=da.replace("-", "");
	d=d.replace("-", "");
	int l = da.length();
	int ll = d.length();
	if(l==ll){
		for(int i=0;i<l;i++){
			char c = d.charAt(i);
			char cc = da.charAt(i);
			System.out.println(c-cc);
			if(c-cc>0){
				System.out.println("大="+d);
				break;
			}else if(c-cc<0){
				System.out.println("小="+d);
				break;
			}
		}
	}
}
	
}
