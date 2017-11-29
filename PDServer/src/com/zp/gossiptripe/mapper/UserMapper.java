package com.zp.gossiptripe.mapper;

import com.zp.gossiptripe.form.LoginForm;
import com.zp.gossiptripe.model.RegistBean;
import com.zp.gossiptripe.model.UserBaseInfoBean;



public interface UserMapper {
	void save(RegistBean registBean);
	int userCount(String username);
	UserBaseInfoBean getUserInfo(LoginForm loginForm);
	UserBaseInfoBean getUserInfoBySession(String session);
}
