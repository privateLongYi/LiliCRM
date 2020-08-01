package com.linxi.entity;

public class Customerstatus {
    private Integer csid;

    private String csname;

    private String cscontent;

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname == null ? null : csname.trim();
    }

    public String getCscontent() {
        return cscontent;
    }

    public void setCscontent(String cscontent) {
        this.cscontent = cscontent == null ? null : cscontent.trim();
    }
}