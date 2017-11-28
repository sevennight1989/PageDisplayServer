package com.zp.gossiptripe.service;

import com.zp.gossiptripe.model.SessionBean;

public interface ISessionService {
	public void saveSession(SessionBean sessionBean);
	
	public void updateSession(SessionBean sessionBean);
}
