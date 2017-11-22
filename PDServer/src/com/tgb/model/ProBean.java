package com.tgb.model;

import java.util.List;

public class ProBean {

	private String title;
	private String approveComment = "";
	private String operaTime = "";
	private List<ResPerson> resPersons;
	private String status;
	
	@Override
	public String toString() {
		return "ProBean [approveComment=" + approveComment + ", operaTime="
				+ operaTime + ", resPersons=" + resPersons + ", status="
				+ status + ", title=" + title + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setMStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getApproveComment() {
		return approveComment;
	}

	public void setApproveComment(String approveComment) {
		this.approveComment = approveComment;
	}

	public String getOperaTime() {
		return operaTime;
	}

	public void setOperaTime(String operaTime) {
		this.operaTime = operaTime;
	}

	public List<ResPerson> getResPersons() {
		return resPersons;
	}

	public void setResPersons(List<ResPerson> resPersons) {
		this.resPersons = resPersons;
	}


}
