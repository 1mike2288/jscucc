package com.wj.jscucc.service;

import com.wj.jscucc.entity.ResultMsg;
import com.wj.jscucc.entity.UserInfo;


public interface UserService {
	
	public ResultMsg addUser(UserInfo user);
	
	
	public ResultMsg queryUser(String code);


	public ResultMsg modifyUser(UserInfo userInfo);
}
