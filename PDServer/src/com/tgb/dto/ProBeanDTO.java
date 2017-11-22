package com.tgb.dto;



public class ProBeanDTO {
	private String title;
	private String approveComment = "";
	private String operaTime = "";
	private String resPersonTAG;
	private String status;
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
	public String getResPersonTAG() {
		return resPersonTAG;
	}
	public void setResPersonTAG(String resPersonTAG) {
		this.resPersonTAG = resPersonTAG;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProBeanDTO [approveComment=" + approveComment + ", operaTime="
				+ operaTime + ", resPersonTAG=" + resPersonTAG + ", status="
				+ status + ", title=" + title + "]";
	}
	
	
}
