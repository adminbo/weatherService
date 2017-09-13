package com.zjkj.wxy.core.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zjkj.wxy.core.dao.baseDao.IBaseDao;
import com.zjkj.wxy.core.domain.Wechat;
import com.zjkj.wxy.core.utils.PageBean;

public interface CofigWxmanagementDao extends IBaseDao<Wechat> {

	//展示公众号管理list
	public List<Wechat> wechatsliList();

	//增加公众号的实体
	public void addWechats(Wechat wechat);

	//修改公众号的实体（1，找寻它对应的id；2，修改）
	public Wechat getWechatid(int id);

	//2修改
	public void updateWechat(Wechat wechat);

	//3删除
	public void deleteWechat(Wechat wechat);

	//4查看
	public void showWechat(Wechat wechat);

	//分页查询

	void pageQuery(PageBean pageBean);

	//离线查询对象
	public List<Wechat> findByCriteria(DetachedCriteria criteria);

}
