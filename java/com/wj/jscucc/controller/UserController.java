package com.wj.jscucc.controller;

import javax.annotation.Resource;

import com.wj.jscucc.entity.ResultMsg;
import com.wj.jscucc.entity.UserInfo;
import com.wj.jscucc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	
	@Resource
	private UserService userService;
	
	
	
	@RequestMapping("/adduser.do")
	@ResponseBody
	public ResultMsg addUser(UserInfo user) {
		ResultMsg rs = userService.addUser(user);
		return rs;
	}
	
	@RequestMapping("/queryUser.do")
	@ResponseBody
	public ResultMsg queryUser(String code) {
		ResultMsg rs = userService.queryUser(code);
		return rs;
	}
	
	@RequestMapping("/modifyUser.do")
	@ResponseBody
	public ResultMsg modifyUser(UserInfo userInfo) {
		ResultMsg rs = userService.modifyUser(userInfo);
		return rs;
	}
}
