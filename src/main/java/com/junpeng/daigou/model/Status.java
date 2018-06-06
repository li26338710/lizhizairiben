package com.junpeng.daigou.model;

public class Status {
    private Integer idstatus;

    private String statustype;

    private String statuscode;

    private String statusvalue;

    private String comment;

    public Integer getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Integer idstatus) {
        this.idstatus = idstatus;
    }

    public String getStatustype() {
        return statustype;
    }

    public void setStatustype(String statustype) {
        this.statustype = statustype;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getStatusvalue() {
        return statusvalue;
    }

    public void setStatusvalue(String statusvalue) {
        this.statusvalue = statusvalue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}