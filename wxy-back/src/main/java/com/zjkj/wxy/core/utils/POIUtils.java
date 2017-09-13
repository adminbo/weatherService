package com.zjkj.wxy.core.utils;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtils {
	 private final static String excel2003L =".xls";    //2003- 版本的excel  
	 private final static String excel2007U =".xlsx";   //2007+ 版本的excel  
    /** 
     * 获取上传文件的工作薄
     * 描述：根据文件后缀，自适应上传文件的版本  
     * @param inStr,fileName 
     * @return 
     * @throws Exception 
     */  
    public static Workbook getImportWorkbook(InputStream inStr,String fileName) throws Exception{  
        Workbook wb = null;  
        String fileType = fileName.substring(fileName.lastIndexOf("."));  
        if(excel2003L.equals(fileType)){  
            wb = new HSSFWorkbook(inStr);  //2003-  
        }else if(excel2007U.equals(fileType)){  
            wb = new XSSFWorkbook(inStr);  //2007+  
        }else{  
            throw new Exception("解析的文件格式有误！");  
        }  
        return wb;  
    } 
/**
 * 文件导出，创建工作薄
 * @param num sheet页数量
 * @param sheetnames sheet页标题名数组
 * @return
 */
    public static HSSFWorkbook getExportWorkbook(Integer num,String[] sheetnames){
    	HSSFWorkbook book = new HSSFWorkbook();//创建工作表，存在内存中
    	for(int i=0;i<num;i++){
    		HSSFSheet sheet = book.createSheet(sheetnames[i]);//指定名的sheet页    		
    	}
    	return  book;
    }
}
