package com.junpeng.daigou.controller.product;

public class ProductResponse {
	private String productId;
	private String productName;
	private String productNameJapan;
	private String brandId;
	private String brandName;
	private String categoryId;
	private String categoryName;
	private double officalPrice;
	private double taxfee;
	private double discount;
	private double costPrice;
	private double costPriceRmb;
	private double recentlyBookPrice;
	private int weight;
	private int istax;
    
    private String discountsettingname;
    private String discountsettingcomment;

    private String iddiscountsetting;
    
    private double salePrice;
    
    
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getIddiscountsetting() {
		return iddiscountsetting;
	}
	public void setIddiscountsetting(String iddiscountsetting) {
		this.iddiscountsetting = iddiscountsetting;
	}
	public String getDiscountsettingname() {
		return discountsettingname;
	}
	public void setDiscountsettingname(String discountsettingname) {
		this.discountsettingname = discountsettingname;
	}
	public String getDiscountsettingcomment() {
		return discountsettingcomment;
	}
	public void setDiscountsettingcomment(String discountsettingcomment) {
		this.discountsettingcomment = discountsettingcomment;
	}
	public double getCostPriceRmb() {
		return costPriceRmb;
	}
	public void setCostPriceRmb(double costPriceRmb) {
		this.costPriceRmb = costPriceRmb;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
	public String getProductNameJapan() {
		return productNameJapan;
	}
	public void setProductNameJapan(String productNameJapan) {
		this.productNameJapan = productNameJapan;
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
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public double getOfficalPrice() {
		return officalPrice;
	}
	public void setOfficalPrice(double officalPrice) {
		this.officalPrice = officalPrice;
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
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getRecentlyBookPrice() {
		return recentlyBookPrice;
	}
	public void setRecentlyBookPrice(double recentlyBookPrice) {
		this.recentlyBookPrice = recentlyBookPrice;
	}
	public int getIstax() {
		return istax;
	}
	public void setIstax(int istax) {
		this.istax = istax;
	}

	
}
