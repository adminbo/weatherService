package com.zjkj.wxy.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjkj.wxy.core.dao.OperaterDao;
import com.zjkj.wxy.core.service.OperaterService;
@Service
@Transactional
public class OperterServiceImpl implements OperaterService{
@Resource
private OperaterDao operaterDao;
}
