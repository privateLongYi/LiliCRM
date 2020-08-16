package com.linxi.entity;

import java.sql.Timestamp;

public class CTransaction {
    private Integer ctId;

    private Integer ctCId;

    private Timestamp ctTime;

    private String ctHospital;

    /**
     *客户姓名
     */
    private String cName;

    /**
     *客户电话
     */
    private String cTel;

    /**
     *报名项目
     */
    private String cProject;

    /**
     *定金
     */
    private String cEarnest;

    /**
     *负责人姓名
     */
    private String uName;

    /**
     *客户来源
     */
    private String cSource;

    /**
     *客户状态
     */
    private String cStatu;

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

    public Timestamp getCtTime() {
        return ctTime;
    }

    public void setCtTime(Timestamp ctTime) {
        this.ctTime = ctTime;
    }

    public String getCtHospital() {
        return ctHospital;
    }

    public void setCtHospital(String ctHospital) {
        this.ctHospital = ctHospital == null ? null : ctHospital.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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

    public String getcEarnest() {
        return cEarnest;
    }

    public void setcEarnest(String cEarnest) {
        this.cEarnest = cEarnest;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getcSource() {
        return cSource;
    }

    public void setcSource(String cSource) {
        this.cSource = cSource;
    }

    public String getcStatu() {
        return cStatu;
    }

    public void setcStatu(String cStatu) {
        this.cStatu = cStatu;
    }
}