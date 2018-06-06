package com.junpeng.daigou.controller.order;

import java.util.Date;

public class OrderDetailRequest {

	private String customerId;
	private String orderId;
	private String orderDetailId;
	private String productId;
	private int count;
	private Date bookDate;
	private double bookPrice;
	private double estiBookPriceJpy;
	private double bookRate;
	private double costPriceJpy;
	private double costRate;
	private String status;

	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getEstiBookPriceJpy() {
		return estiBookPriceJpy;
	}

	public void setEstiBookPriceJpy(double estiBookPriceJpy) {
		this.estiBookPriceJpy = estiBookPriceJpy;
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

	public double getCostRate() {
		return costRate;
	}

	public void setCostRate(double costRate) {
		this.costRate = costRate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
