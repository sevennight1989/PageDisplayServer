package com.tgb.model;

/**
 * Created by Percy on 11-9 0009.
 */

public class DataBean {
	/**
	 * fileName : 15101087699190.jpg filetypeid : 381 format : jpg loanID :
	 * 4053367 padocId : 91245b767e4eb644216ac3136c06c4e3ea2 pagenum : 4
	 */

	private String fileName;
	private String filetypeid;
	private String format;
	private String loanID;
	private String padocId;
	private String pagenum;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFiletypeid() {
		return filetypeid;
	}

	public void setFiletypeid(String filetypeid) {
		this.filetypeid = filetypeid;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLoanID() {
		return loanID;
	}

	public void setLoanID(String loanID) {
		this.loanID = loanID;
	}

	public String getPadocId() {
		return padocId;
	}

	public void setPadocId(String padocId) {
		this.padocId = padocId;
	}

	public String getPagenum() {
		return pagenum;
	}

	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
}
