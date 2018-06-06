package com.junpeng.daigou.controller.order;

public class OrderDetailResponse {

	private String orderDetailId;

	private String orderId;
	private String productId;
	private String productName;
	private String bookDate;
	private int count;
	private double bookPriceJpy;
	private double bookPrice;
	private double bookPriceSum;
	private double estiBookPriceJpy;
	private double estiBookPrice;
	private double bookRate;
	private double costPriceJpy;
	private double costPrice;
	private double costRate;
	private double profit;
	private String status;
	private String customerId;
	private String customerName;
	private String statusStr;
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getBookPriceJpy() {
		return bookPriceJpy;
	}
	public void setBookPriceJpy(double bookPriceJpy) {
		this.bookPriceJpy = bookPriceJpy;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public double getBookPriceSum() {
		return bookPriceSum;
	}
	public void setBookPriceSum(double bookPriceSum) {
		this.bookPriceSum = bookPriceSum;
	}
	public double getEstiBookPriceJpy() {
		return estiBookPriceJpy;
	}
	public void setEstiBookPriceJpy(double estiBookPriceJpy) {
		this.estiBookPriceJpy = estiBookPriceJpy;
	}
	public double getEstiBookPrice() {
		return estiBookPrice;
	}
	public void setEstiBookPrice(double estiBookPrice) {
		this.estiBookPrice = estiBookPrice;
	}
	public double getBookRate() {
		return bookRate;
	}
	public void setBookRate(double bookRate) {
		this.bookRate = bookRate;
	}
	public double getCostPriceJpy() {
		return costPriceJpy;
	}
	public void setCostPriceJpy(double costPriceJpy) {
		this.costPriceJpy = costPriceJpy;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getCostRate() {
		return costRate;
	}
	public void setCostRate(double costRate) {
		this.costRate = costRate;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	
}
