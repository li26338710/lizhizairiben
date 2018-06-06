package com.junpeng.daigou.model;

import java.util.Date;

public class OrderDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.idorderdetail
     *
     * @mbggenerated
     */
    private Integer idorderdetail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.idorder
     *
     * @mbggenerated
     */
    private Integer idorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.idproduct
     *
     * @mbggenerated
     */
    private Integer idproduct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.count
     *
     * @mbggenerated
     */
    private Integer count;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.bookdate
     *
     * @mbggenerated
     */
    private Date bookdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.bookprice
     *
     * @mbggenerated
     */
    private Double bookprice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.esticostprice
     *
     * @mbggenerated
     */
    private Double esticostprice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.costprice
     *
     * @mbggenerated
     */
    private Double costprice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.bookrate
     *
     * @mbggenerated
     */
    private Double bookrate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.costrate
     *
     * @mbggenerated
     */
    private Double costrate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.profit
     *
     * @mbggenerated
     */
    private Double profit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderdetail.status
     *
     * @mbggenerated
     */
    private String status;
    
    private String productname;
    
    private String productnamejapan;
    
    private Integer idcustomer;
    
    private String customername;
    
    private String statusvalue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.idorderdetail
     *
     * @return the value of orderdetail.idorderdetail
     *
     * @mbggenerated
     */
    public Integer getIdorderdetail() {
        return idorderdetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.idorderdetail
     *
     * @param idorderdetail the value for orderdetail.idorderdetail
     *
     * @mbggenerated
     */
    public void setIdorderdetail(Integer idorderdetail) {
        this.idorderdetail = idorderdetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.idorder
     *
     * @return the value of orderdetail.idorder
     *
     * @mbggenerated
     */
    public Integer getIdorder() {
        return idorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.idorder
     *
     * @param idorder the value for orderdetail.idorder
     *
     * @mbggenerated
     */
    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.idproduct
     *
     * @return the value of orderdetail.idproduct
     *
     * @mbggenerated
     */
    public Integer getIdproduct() {
        return idproduct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.idproduct
     *
     * @param idproduct the value for orderdetail.idproduct
     *
     * @mbggenerated
     */
    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.count
     *
     * @return the value of orderdetail.count
     *
     * @mbggenerated
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.count
     *
     * @param count the value for orderdetail.count
     *
     * @mbggenerated
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.bookdate
     *
     * @return the value of orderdetail.bookdate
     *
     * @mbggenerated
     */
    public Date getBookdate() {
        return bookdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.bookdate
     *
     * @param bookdate the value for orderdetail.bookdate
     *
     * @mbggenerated
     */
    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.bookprice
     *
     * @return the value of orderdetail.bookprice
     *
     * @mbggenerated
     */
    public Double getBookprice() {
        return bookprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.bookprice
     *
     * @param bookprice the value for orderdetail.bookprice
     *
     * @mbggenerated
     */
    public void setBookprice(Double bookprice) {
        this.bookprice = bookprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.esticostprice
     *
     * @return the value of orderdetail.esticostprice
     *
     * @mbggenerated
     */
    public Double getEsticostprice() {
        return esticostprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.esticostprice
     *
     * @param esticostprice the value for orderdetail.esticostprice
     *
     * @mbggenerated
     */
    public void setEsticostprice(Double esticostprice) {
        this.esticostprice = esticostprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.costprice
     *
     * @return the value of orderdetail.costprice
     *
     * @mbggenerated
     */
    public Double getCostprice() {
        return costprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.costprice
     *
     * @param costprice the value for orderdetail.costprice
     *
     * @mbggenerated
     */
    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.bookrate
     *
     * @return the value of orderdetail.bookrate
     *
     * @mbggenerated
     */
    public Double getBookrate() {
        return bookrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.bookrate
     *
     * @param bookrate the value for orderdetail.bookrate
     *
     * @mbggenerated
     */
    public void setBookrate(Double bookrate) {
        this.bookrate = bookrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.costrate
     *
     * @return the value of orderdetail.costrate
     *
     * @mbggenerated
     */
    public Double getCostrate() {
        return costrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.costrate
     *
     * @param costrate the value for orderdetail.costrate
     *
     * @mbggenerated
     */
    public void setCostrate(Double costrate) {
        this.costrate = costrate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.profit
     *
     * @return the value of orderdetail.profit
     *
     * @mbggenerated
     */
    public Double getProfit() {
        return profit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.profit
     *
     * @param profit the value for orderdetail.profit
     *
     * @mbggenerated
     */
    public void setProfit(Double profit) {
        this.profit = profit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderdetail.status
     *
     * @return the value of orderdetail.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderdetail.status
     *
     * @param status the value for orderdetail.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

	public Integer getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Integer idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getStatusvalue() {
		return statusvalue;
	}

	public void setStatusvalue(String statusvalue) {
		this.statusvalue = statusvalue;
	}
	
}
