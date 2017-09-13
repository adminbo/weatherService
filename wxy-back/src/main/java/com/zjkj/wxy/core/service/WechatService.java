package com.zjkj.wxy.core.service;

import com.zjkj.wxy.core.domain.Wechat;

public interface WechatService {

	void merge(Wechat wechat);

	void save(Wechat w);

	void update(Wechat w);
}
