package com.junpeng.daigou.controller.status;

public class StatusResponse {
	
	private String idstatus;
	private String statusType;
	private String statusCode;
	private String statusStr;
	private String comment;
	public String getIdstatus() {
		return idstatus;
	}
	public void setIdstatus(String idstatus) {
		this.idstatus = idstatus;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
