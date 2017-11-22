package com.tgb.model;

public class ResPerson {

	private String name;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ResPerson [name=" + name + ", phone=" + phone + "]";
	}
	
}
