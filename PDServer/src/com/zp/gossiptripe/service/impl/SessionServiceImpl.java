package com.zp.gossiptripe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.gossiptripe.mapper.SessionMapper;
import com.zp.gossiptripe.model.SessionBean;
import com.zp.gossiptripe.service.ISessionService;
@Service
@Transactional 
public class SessionServiceImpl implements ISessionService {
	
	@Resource
	SessionMapper mSessionMapper;
	
	public void saveSession(SessionBean sessionBean) {
		mSessionMapper.saveSession(sessionBean);

	}

	public void updateSession(SessionBean sessionBean) {
		mSessionMapper.updateSession(sessionBean);

	}

}
