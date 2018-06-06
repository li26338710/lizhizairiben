package com.junpeng.daigou.model;

public class PurchasingProduct {
	
	private String idproduct;
	private String productname;
	private String productnamejapan;
	private double officalprice;
	private String discountsettingcomment;
    private double discount;
    private double costPrice;
    private double costPriceJpy;
    private double sumcount;
	public String getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductnamejapan() {
		return productnamejapan;
	}
	public void setProductnamejapan(String productnamejapan) {
		this.productnamejapan = productnamejapan;
	}
	public double getOfficalprice() {
		return officalprice;
	}
	public void setOfficalprice(double officalprice) {
		this.officalprice = officalprice;
	}
	public String getDiscountsettingcomment() {
		return discountsettingcomment;
	}
	public void setDiscountsettingcomment(String discountsettingcomment) {
		this.discountsettingcomment = discountsettingcomment;
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
	public double getCostPriceJpy() {
		return costPriceJpy;
	}
	public void setCostPriceJpy(double costPriceJpy) {
		this.costPriceJpy = costPriceJpy;
	}
	public double getSumcount() {
		return sumcount;
	}
	public void setSumcount(double sumcount) {
		this.sumcount = sumcount;
	}

    
}
