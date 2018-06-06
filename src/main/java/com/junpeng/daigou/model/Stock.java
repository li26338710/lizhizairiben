package com.junpeng.daigou.model;

import java.util.Date;

public class Stock {
    private Integer idstock;

    private Integer idproduct;

    private Integer idorderdetail;

    private Integer idpurchasedetail;

    private Integer stockcount;

    private Date stockdate;

    private String comment;

    public Integer getIdstock() {
        return idstock;
    }

    public void setIdstock(Integer idstock) {
        this.idstock = idstock;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public Integer getIdorderdetail() {
        return idorderdetail;
    }

    public void setIdorderdetail(Integer idorderdetail) {
        this.idorderdetail = idorderdetail;
    }

    public Integer getIdpurchasedetail() {
        return idpurchasedetail;
    }

    public void setIdpurchasedetail(Integer idpurchasedetail) {
        this.idpurchasedetail = idpurchasedetail;
    }

    public Integer getStockcount() {
        return stockcount;
    }

    public void setStockcount(Integer stockcount) {
        this.stockcount = stockcount;
    }

    public Date getStockdate() {
        return stockdate;
    }

    public void setStockdate(Date stockdate) {
        this.stockdate = stockdate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}