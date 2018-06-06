package com.junpeng.daigou.controller.purchase;

import java.util.Date;

public class PurchaseDetailRequest {

	private String productId;
	private String marketId;
	private String brandId;
	private int count;
	private double singlePrice;
	private double rate;
	private Date purchaseDate;
	private String purchaseDetailId;
	private String purchaseId;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(double singlePrice) {
		this.singlePrice = singlePrice;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPurchaseDetailId() {
		return purchaseDetailId;
	}
	public void setPurchaseDetailId(String purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
	}
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
}
