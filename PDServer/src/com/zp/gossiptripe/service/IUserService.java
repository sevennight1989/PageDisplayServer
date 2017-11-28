package com.zp.gossiptripe.service;

import com.zp.gossiptripe.form.LoginForm;
import com.zp.gossiptripe.model.RegistBean;
import com.zp.gossiptripe.model.UserBaseInfoBean;

public interface IUserService {
	
	void saveUser(RegistBean registBean);
	int userCount(String username);
	UserBaseInfoBean getUserInfo(LoginForm loginForm);
	
}
