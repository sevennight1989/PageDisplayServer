package com.zp.gossiptripe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.gossiptripe.form.LoginForm;
import com.zp.gossiptripe.mapper.UserMapper;
import com.zp.gossiptripe.model.RegistBean;
import com.zp.gossiptripe.model.UserBaseInfoBean;
import com.zp.gossiptripe.service.IUserService;
@Service
@Transactional 
public class UserServiceImpl implements IUserService {

	@Resource
	UserMapper mUserMapper;
	
	public void saveUser(RegistBean registBean) {
		mUserMapper.save(registBean);
	}

	public int userCount(String username) {
		return mUserMapper.userCount(username);
	}

	public UserBaseInfoBean getUserInfo(LoginForm loginForm) {
		return mUserMapper.getUserInfo(loginForm);
	}

	public UserBaseInfoBean getUserInfoBySession(String session) {
		return mUserMapper.getUserInfoBySession(session);
	}

}
