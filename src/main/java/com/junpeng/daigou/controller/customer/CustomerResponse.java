package com.junpeng.daigou.controller.customer;

public class CustomerResponse {

	private String customerId;
	private String customerName;
	private String wxId;
	private String recommonder;
	private String credit;
	private String phone;
	private String address;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public String getRecommonder() {
		return recommonder;
	}
	public void setRecommonder(String recommonder) {
		this.recommonder = recommonder;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
