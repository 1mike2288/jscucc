package com.wj.jscucc.controller;

import javax.annotation.Resource;

import com.wj.jscucc.entity.ResultMsg;
import com.wj.jscucc.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PhoneController {

	
	@Resource
    PhoneService phoneService;
	
	@RequestMapping("/queryPhone.do")
	@ResponseBody
	public ResultMsg queryPhone() {
		ResultMsg rs = phoneService.queryPhone();
		return rs;
	}
	
	
	@RequestMapping("/queryPhonePage.do")
	@ResponseBody
	public ResultMsg queryPhonePage(String begin,String end,String pageSize) {
		ResultMsg rs=phoneService.queryPhonePage(begin, end, pageSize);
		return rs;
	}
	
	
	@RequestMapping("/querykdInfo.do")
	@ResponseBody
	public ResultMsg querykdInfo() {
		ResultMsg rs = phoneService.querykdInfo();
		return rs;
	}
	
	
	@RequestMapping("/updateStatus.do")
	@ResponseBody
	public ResultMsg updateStatus(String status,String phone) {
		ResultMsg rs = phoneService.updateStatus(status, phone);
		return rs;
	}
	
	@RequestMapping("/addUserPhone.do")
	@ResponseBody
	public ResultMsg addUserPhone(String idCard,String phone) {
		ResultMsg rs = phoneService.addUserPhone(idCard, phone);
		return rs;
	}
	
	
	@RequestMapping("/addUserKd.do")
	@ResponseBody
	public ResultMsg addUserKd(String idCard,String phone,String kdname,String kdaddress) {
		ResultMsg rs = phoneService.addUserKd(idCard, phone, kdname, kdaddress);
		return rs;		
	}
}
