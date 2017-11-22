package com.tgb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tgb.mapper.DataMapper;
import com.tgb.model.DataBean;
import com.tgb.service.ImageService;

@Service
@Transactional
public class ImagerServiceImpl implements ImageService {

	@Resource
	private DataMapper mapper;
	
	public List<DataBean> getImageData() {
		// TODO Auto-generated method stub
		return mapper.getImageData();
	}

}
