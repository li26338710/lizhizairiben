package com.junpeng.daigou.controller.purchase;

public class PurchaseDetailResponse {
	private String purchaseDetailId;
	private String productName;
	private String productId;
	private int count;
	private String purchaseId;
	private double singlePrice;
	private double singlePriceJpy;
	private double rate;
	private double sumPrice;
	private double sumPriceJpy;
	private int getScore;
	private String marketId;
	private String marketName;
	private String brandId;
	private String brandName;
	public String getPurchaseDetailId() {
		return purchaseDetailId;
	}
	public void setPurchaseDetailId(String purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public double getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(double singlePrice) {
		this.singlePrice = singlePrice;
	}
	public double getSinglePriceJpy() {
		return singlePriceJpy;
	}
	public void setSinglePriceJpy(double singlePriceJpy) {
		this.singlePriceJpy = singlePriceJpy;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public double getSumPriceJpy() {
		return sumPriceJpy;
	}
	public void setSumPriceJpy(double sumPriceJpy) {
		this.sumPriceJpy = sumPriceJpy;
	}
	public int getGetScore() {
		return getScore;
	}
	public void setGetScore(int getScore) {
		this.getScore = getScore;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	
}
