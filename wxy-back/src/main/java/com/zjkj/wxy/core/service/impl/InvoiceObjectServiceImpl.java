package com.zjkj.wxy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.imageio.spi.RegisterableService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.AlignedEnvironmenDao;
import com.zjkj.wxy.core.dao.CofigWxmanagementDao;
import com.zjkj.wxy.core.dao.InvoiceDao;
import com.zjkj.wxy.core.dao.SchoolEnvireDao;
import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Img;
import com.zjkj.wxy.core.domain.Invoice;
import com.zjkj.wxy.core.domain.Operator;
import com.zjkj.wxy.core.domain.Reg;
import com.zjkj.wxy.core.service.AligendEnvireService;
import com.zjkj.wxy.core.service.InvoiceObejectService;
import com.zjkj.wxy.core.service.OperatorObejectService;
import com.zjkj.wxy.core.service.RegObejectService;
import com.zjkj.wxy.core.service.SchoolEnvireService;
import com.zjkj.wxy.core.utils.PageBean;

@Service("invoiceObejectService")
@Transactional
public class InvoiceObjectServiceImpl implements InvoiceObejectService {

	@Resource
	private InvoiceDao invoiceDao;

	@Override
	public List<Invoice> InvoiceliList() {
		// TODO Auto-generated method stub
		return invoiceDao.findAll();
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		invoiceDao.pageQuery(pageBean);
	}

	@Override
	public void addInvoice(Invoice reg) {
		// TODO Auto-generated method stub
		invoiceDao.save(reg);
	}

	@Override
	public Invoice getInvoiceid(Integer id) {
		// TODO Auto-generated method stub
		return invoiceDao.findById(id);
	}

	@Override
	public void updateInvoice(Invoice reg) {
		// TODO Auto-generated method stub
		invoiceDao.merge(reg);
	}

	@Override
	public void deletInvoice(Invoice reg) {
		// TODO Auto-generated method stub
		invoiceDao.delete(reg);
	}
}
