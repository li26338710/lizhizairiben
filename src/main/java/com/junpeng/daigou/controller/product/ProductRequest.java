package com.junpeng.daigou.controller.product;

public class ProductRequest {

	private String productId;
	private String brandId;
	private String categoryId;
	private String productName;
	private String productNameJapan;
	private double officalPrice;
	private double recentlyBookPrice;
	private String istax;
	private double taxfee;
	private double discount;
	private int weight;
	
	private String iddiscountsetting;
	
    private double salePrice;
	
	
	
	public String getIddiscountsetting() {
		return iddiscountsetting;
	}
	public void setIddiscountsetting(String iddiscountsetting) {
		this.iddiscountsetting = iddiscountsetting;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameJapan() {
		return productNameJapan;
	}
	public void setProductNameJapan(String productNameJapan) {
		this.productNameJapan = productNameJapan;
	}
	public double getOfficalPrice() {
		return officalPrice;
	}
	public void setOfficalPrice(double officalPrice) {
		this.officalPrice = officalPrice;
	}
	public double getRecentlyBookPrice() {
		return recentlyBookPrice;
	}
	public void setRecentlyBookPrice(double recentlyBookPrice) {
		this.recentlyBookPrice = recentlyBookPrice;
	}
	public String getIstax() {
		return istax;
	}
	public void setIstax(String istax) {
		this.istax = istax;
	}
	
	public double getTaxfee() {
		return taxfee;
	}
	public void setTaxfee(double taxfee) {
		this.taxfee = taxfee;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
}
