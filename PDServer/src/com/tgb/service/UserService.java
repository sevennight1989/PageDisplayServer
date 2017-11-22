package com.tgb.service;

import java.util.List;

import com.tgb.dto.ProBeanDTO;
import com.tgb.dto.ResPersonDTO;
import com.tgb.dto.UserDTO;
import com.tgb.model.ProBean;
import com.tgb.model.User;


public interface UserService {
	void save(User user);
	boolean update(User user);
	boolean delete(int id);
	UserDTO findById(int id);
	List<UserDTO> findAll();
	List<ProBeanDTO> findProBean();
	List<ResPersonDTO> findResPerson(String tag);
	List<ProBean> findProgress();
}
