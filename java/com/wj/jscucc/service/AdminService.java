package com.wj.jscucc.service;

import com.wj.jscucc.entity.Admin;
import com.wj.jscucc.entity.EmpInfo;
import com.wj.jscucc.entity.ResultMsg;

public interface AdminService {
	
	public ResultMsg checkLogin(String account, String password);

	public ResultMsg findByIdAdmin(int id);
	
	public ResultMsg findAdminAll();
	
	public ResultMsg findEmpInfo(String account);

	public ResultMsg updatePwd(String account, String newpwd, String oldpwd);

	public ResultMsg updateEmpInfo(EmpInfo empInfo);

	public ResultMsg addAdmin(Admin admin);

	public ResultMsg updateAdmin(Admin admin);

	public ResultMsg deleteAdmin(String account);
}
