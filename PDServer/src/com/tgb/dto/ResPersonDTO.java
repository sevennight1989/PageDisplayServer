package com.tgb.dto;

public class ResPersonDTO {
	private String name;
	private String phone;
	private String tag;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "ResPersonDTO [name=" + name + ", phone=" + phone + ", tag="
				+ tag + "]";
	}
	
}
