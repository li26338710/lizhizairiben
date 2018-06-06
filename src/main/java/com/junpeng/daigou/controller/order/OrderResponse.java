package com.junpeng.daigou.controller.order;

public class OrderResponse {

	private String orderId;
	
	private String customerId;

	private String customerName;

	private String wxid;

	private String bookDate;
	
	private double deposit;
	
	private String depositType;
	
	private double payment;
	
	private String paymentType;
	
	private double postprice;

	private double remaindprice;

	private double sumprice;
	
	private double sumprofit;
	
	private String status;
	
	private String statusStr;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
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

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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

	
	public double getSumprice() {
		return sumprice;
	}

	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}
	
	public double getSumprofit() {
		return sumprofit;
	}

	public void setSumprofit(double sumprofit) {
		this.sumprofit = sumprofit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

}
