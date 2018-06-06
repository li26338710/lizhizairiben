package com.junpeng.daigou.common;

import java.util.List;

public class CommonResponse<T> {

	private List<T> aaData;
	private String updateResult;

	public CommonResponse(List<T> aaData) {
		super();
		this.aaData = aaData;
	}
	
	public CommonResponse(String updateResult) {
		super();
		this.updateResult = updateResult;
	}

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

	public String getUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(String updateResult) {
		this.updateResult = updateResult;
	}
	

}
