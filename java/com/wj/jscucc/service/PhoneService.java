package com.wj.jscucc.service;

import com.wj.jscucc.entity.ResultMsg;

public interface PhoneService {
	
	public ResultMsg queryPhone();
	
	public ResultMsg queryPhonePage(String begin, String end, String pageSize);

	public ResultMsg querykdInfo();
	
	public ResultMsg updateStatus(String status, String phone);

	public ResultMsg addUserPhone(String idCard, String phone);
	
	public ResultMsg addUserKd(String idCard, String phone, String kdname, String kdaddress);
}
