package com.junpeng.daigou.controller.order;

import java.util.Date;

public class OrderRequest {
	private String orderId;
	private String customerName;
	private String customerId;
	private String wxid;
	private Date bookDate;
	private double deposit;
	private String depositType;
	private double payment;
	private String paymentType;
	private double postprice;
	private double remaindprice;
	private String status;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getWxid() {
		return wxid;
	}
	public void setWxid(String wxid) {
		this.wxid = wxid;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getPostprice() {
		return postprice;
	}
	public void setPostprice(double postprice) {
		this.postprice = postprice;
	}
	public double getRemaindprice() {
		return remaindprice;
	}
	public void setRemaindprice(double remaindprice) {
		this.remaindprice = remaindprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
}
