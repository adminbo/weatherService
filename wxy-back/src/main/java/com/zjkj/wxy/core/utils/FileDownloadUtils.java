package com.zjkj.wxy.core.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * 文件下载工具类
 * @author 
 *
 */
public class FileDownloadUtils {
   
	/** * @Description 下载文件 * 
	 * @param fileName * 
	 * @param file * 
	 * @return *
	 *  @throws IOException 
     */ 
	public static ResponseEntity<byte[]> download(String fileName, File file) throws IOException {
		String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1"); 
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
		headers.set("Content-Disposition", "attachment; filename=\"" + dfileName + "\"");
		//headers.setContentDispositionFormData("attachment", dfileName); 
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED); }
	
}