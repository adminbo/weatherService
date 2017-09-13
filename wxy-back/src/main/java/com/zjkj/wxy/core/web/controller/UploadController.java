package com.zjkj.wxy.core.web.controller;

import java.io.InputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zjkj.wxy.core.utils.POIUtils;

@Controller
@RequestMapping("/file")
public class UploadController {
/**
 * 文件上传demo
 * @throws Exception 
 */
	@RequestMapping("/upload.do")
	public void upload(MultipartFile file) throws Exception{
		InputStream inputStream = file.getInputStream();//文件输入流
		String name = file.getOriginalFilename();//文件名
		Workbook workbook = POIUtils.getImportWorkbook(inputStream, name);
		// 加载第一个sheet页
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0) {
				// 第一行为文件的标题行，忽略
				continue;
			}
			// 获得当前行的某一列
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
System.out.println(id+"---"+province+"------"+city);
		}
		inputStream.close();//关流
	}
}
