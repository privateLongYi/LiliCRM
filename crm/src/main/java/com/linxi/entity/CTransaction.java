package com.linxi.entity;

import java.util.Date;

public class CTransaction {
    private Integer ctId;

    private Integer ctCId;

    private Date ctTime;

    private String ctHospital;

    private Integer ctArrive;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getCtCId() {
        return ctCId;
    }

    public void setCtCId(Integer ctCId) {
        this.ctCId = ctCId;
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
    }

    public String getCtHospital() {
        return ctHospital;
    }

    public void setCtHospital(String ctHospital) {
        this.ctHospital = ctHospital == null ? null : ctHospital.trim();
    }

    public Integer getCtArrive() {
        return ctArrive;
    }

    public void setCtArrive(Integer ctArrive) {
        this.ctArrive = ctArrive;
    }
}