package com.zjkj.wxy.core.service;

import java.util.List;

import com.zjkj.wxy.core.domain.Photo;

public interface PhotoService {

	List<Photo> getphotoByAbid(Integer abid);
}
