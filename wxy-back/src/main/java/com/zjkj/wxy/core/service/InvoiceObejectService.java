package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Invoice;
import com.zjkj.wxy.core.domain.Operator;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.utils.PageBean;


public interface InvoiceObejectService {

	//展示公众号管理list
	public List<Invoice> InvoiceliList();
	
	//展示公众号管理list和分页查询
	public void pageQuery(PageBean pageBean);
	
	
	//增加公众号的实体
	public void addInvoice(Invoice reg);
	
	//修改公众号的实体（1，找寻它对应的id；2，修改 ；3，查看）
	 public Invoice getInvoiceid(Integer id);  
    
	 //2修改
	 public void updateInvoice(Invoice  reg);
	 
	    
	 //删除公众号实体
	 public void deletInvoice(Invoice reg);

	    
}
