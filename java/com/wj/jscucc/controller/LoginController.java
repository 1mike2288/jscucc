package com.wj.jscucc.controller;

import javax.annotation.Resource;

import com.wj.jscucc.entity.ResultMsg;
import com.wj.jscucc.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@Resource
    AdminService adminService;
	
	
	@RequestMapping("/tologin.do")
	public String tolog() {
		return "login";
	}
	
	
	
	@RequestMapping("/checklogin.do")
	@ResponseBody
	public ResultMsg checkLogin(String account,String pwd) {
		ResultMsg rm = adminService.checkLogin(account, pwd);
		return rm;
	}
	

}
