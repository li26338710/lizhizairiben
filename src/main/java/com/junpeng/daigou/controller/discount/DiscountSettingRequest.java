package com.junpeng.daigou.controller.discount;

public class DiscountSettingRequest {
	private String idDiscountSetting;

	private String discountSettingName;
	
	private String discountSettingComment;
	
	private String discount;

	public String getIdDiscountSetting() {
		return idDiscountSetting;
	}

	public void setIdDiscountSetting(String idDiscountSetting) {
		this.idDiscountSetting = idDiscountSetting;
	}

	public String getDiscountSettingName() {
		return discountSettingName;
	}

	public void setDiscountSettingName(String discountSettingName) {
		this.discountSettingName = discountSettingName;
	}

	public String getDiscountSettingComment() {
		return discountSettingComment;
	}

	public void setDiscountSettingComment(String discountSettingComment) {
		this.discountSettingComment = discountSettingComment;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
}
