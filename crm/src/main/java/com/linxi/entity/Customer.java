package com.linxi.entity;

import java.sql.Date;

public class Customer {
    private Integer cId;

    private String cName;

    private String cSex;

    private Integer cAge;

    private String cTel;

    private String cProject;

    private String cPlaceTime;

    private String cRemark;

    private Integer cEarnest;

    private Integer cUId;

    private String cSource;

    private String cMessage;

    private String cCallback;

    private String cStatu;

    /**
     *负责人姓名
     */
    private String cUName;

    /**
     *预约门诊
     */
    private String ctHospital;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex;
    }

    public Integer getcAge() {
        return cAge;
    }

    public void setcAge(Integer cAge) {
        this.cAge = cAge;
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public String getcProject() {
        return cProject;
    }

    public void setcProject(String cProject) {
        this.cProject = cProject;
    }

    public String getcPlaceTime() {
        return cPlaceTime;
    }

    public void setcPlaceTime(String cPlaceTime) {
        this.cPlaceTime = cPlaceTime;
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    public Integer getcEarnest() {
        return cEarnest;
    }

    public void setcEarnest(Integer cEarnest) {
        this.cEarnest = cEarnest;
    }

    public Integer getcUId() {
        return cUId;
    }

    public void setcUId(Integer cUId) {
        this.cUId = cUId;
    }

    public String getcSource() {
        return cSource;
    }

    public void setcSource(String cSource) {
        this.cSource = cSource;
    }

    public String getcMessage() {
        return cMessage;
    }

    public void setcMessage(String cMessage) {
        this.cMessage = cMessage;
    }

    public String getcCallback() {
        return cCallback;
    }

    public void setcCallback(String cCallback) {
        this.cCallback = cCallback;
    }

    public String getcStatu() {
        return cStatu;
    }

    public void setcStatu(String cStatu) {
        this.cStatu = cStatu;
    }

    public String getcUName() {
        return cUName;
    }

    public void setcUName(String cUName) {
        this.cUName = cUName;
    }

    public String getCtHospital() {
        return ctHospital;
    }

    public void setCtHospital(String ctHospital) {
        this.ctHospital = ctHospital;
    }

    public Customer() {
    }

    public Customer(Integer cId, String cName, String cSex, Integer cAge, String cTel, String cProject, String cPlaceTime, String cRemark, Integer cEarnest, Integer cUId, String cSource, String cMessage, String cCallback, String cStatu) {
        this.cId = cId;
        this.cName = cName;
        this.cSex = cSex;
        this.cAge = cAge;
        this.cTel = cTel;
        this.cProject = cProject;
        this.cPlaceTime = cPlaceTime;
        this.cRemark = cRemark;
        this.cEarnest = cEarnest;
        this.cUId = cUId;
        this.cSource = cSource;
        this.cMessage = cMessage;
        this.cCallback = cCallback;
        this.cStatu = cStatu;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cSex='" + cSex + '\'' +
                ", cAge=" + cAge +
                ", cTel='" + cTel + '\'' +
                ", cProject='" + cProject + '\'' +
                ", cPlaceTime='" + cPlaceTime + '\'' +
                ", cRemark='" + cRemark + '\'' +
                ", cEarnest=" + cEarnest +
                ", cUId=" + cUId +
                ", cSource='" + cSource + '\'' +
                ", cMessage='" + cMessage + '\'' +
                ", cCallback='" + cCallback + '\'' +
                ", cStatu='" + cStatu + '\'' +
                ", cUName='" + cUName + '\'' +
                ", ctHospital='" + ctHospital + '\'' +
                '}';
    }
}