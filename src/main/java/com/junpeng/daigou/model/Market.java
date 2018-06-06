package com.junpeng.daigou.model;

import java.util.Date;

public class Market {
    private Integer idmarket;

    private String marketname;

    private String comment;

    private String createuser;

    private Date createdate;

    private String updateuser;

    private Date updatedate;

    private String isactice;

    public Integer getIdmarket() {
        return idmarket;
    }

    public void setIdmarket(Integer idmarket) {
        this.idmarket = idmarket;
    }

    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getIsactice() {
        return isactice;
    }

    public void setIsactice(String isactice) {
        this.isactice = isactice;
    }
}