package com.wj.jscucc.controller;

import javax.annotation.Resource;

import com.wj.jscucc.entity.Admin;
import com.wj.jscucc.entity.EmpInfo;
import com.wj.jscucc.entity.ResultMsg;
import com.wj.jscucc.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AdminController {
	
	@Resource
    AdminService adminService;
	
	
	@RequestMapping("/findByIdAdmin.do")
	@ResponseBody
	public ResultMsg findByIdAdmin(int id) {
		ResultMsg  rsm = adminService.findByIdAdmin(id);
		return rsm;
	}
	
	
	
	@RequestMapping("/findAdminRole.do")
	@ResponseBody
	public ResultMsg findAdminAll() {
		ResultMsg rs = adminService.findAdminAll();
		return rs;
	}
	
	@RequestMapping("/findEmpInfo.do")
	@ResponseBody
	public ResultMsg findEmpInfo(String account){
		ResultMsg rs = adminService.findEmpInfo(account);
		return rs;
	}
	
	@RequestMapping("/updatepwd.do")
	@ResponseBody
	public ResultMsg updatePwd(String account,String newpwd,String oldpwd) {
		ResultMsg rs = adminService.updatePwd(account, newpwd,oldpwd);
		return rs;
	}
	
	@RequestMapping("/updateEmpInfo.do")
	@ResponseBody
	public ResultMsg updateEmpInfo(EmpInfo admininfo) {
		System.out.println(admininfo.toString());
		
		ResultMsg rs = adminService.updateEmpInfo(admininfo);
		return rs;
	}
	
	@RequestMapping("/addAdmin.do")
	@ResponseBody
	public ResultMsg addAdmin(Admin admin) {
		ResultMsg rs = adminService.addAdmin(admin);
		return rs;
	}
	
	@RequestMapping("/updateAdmin.do")
	@ResponseBody
	public ResultMsg updateAdmin(Admin admin) {
		ResultMsg rs = adminService.updateAdmin(admin);
		return rs;
	}
	
	@RequestMapping("/delAdmin.do")
	@ResponseBody
	public ResultMsg deleteAdmin(String account) {
		ResultMsg rs = adminService.deleteAdmin(account);
		return rs;
	}
}
