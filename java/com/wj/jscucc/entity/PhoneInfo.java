package com.wj.jscucc.entity;

import java.io.Serializable;

public class PhoneInfo implements Serializable{
	
	private int id;
	private String phone;
	private double prestore;
	private double basic;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getPrestore() {
		return prestore;
	}
	public void setPrestore(double prestore) {
		this.prestore = prestore;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PhoneInfo [id=" + id + ", phone=" + phone + ", prestore=" + prestore + ", basic=" + basic + ", status="
				+ status + "]";
	}
	
	

}
