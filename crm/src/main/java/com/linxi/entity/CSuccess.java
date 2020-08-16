package com.linxi.entity;

import java.sql.Timestamp;

public class CSuccess {
    private Integer csId;

    private Integer csCtId;

    private Timestamp csTime;

    private String csMajor;

    private Integer csMajorsum;

    private String csElse;

    private Integer csElsesum;

    private Integer csSum;

    private Integer csPaysum;

    private String csFeedback;

    private String csCallback;

    /**
     *客户姓名
     */
    private String cName;

    /**
     *客户电话
     */
    private String cTel;

    /**
     *成交门诊（预约门诊）
     */
    private String ctHospital;

    /**
     *成交项目（客户报名项目）
     */
    private String cProject;

    /**
     *成交定金（客户定金）
     */
    private String cEarnest;

    /**
     *负责人
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

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
    }

    public Integer getCsCtId() {
        return csCtId;
    }

    public void setCsCtId(Integer csCtId) {
        this.csCtId = csCtId;
    }

    public Timestamp getCsTime() {
        return csTime;
    }

    public void setCsTime(Timestamp csTime) {
        this.csTime = csTime;
    }

    public String getCsMajor() {
        return csMajor;
    }

    public void setCsMajor(String csMajor) {
        this.csMajor = csMajor == null ? null : csMajor.trim();
    }

    public Integer getCsMajorsum() {
        return csMajorsum;
    }

    public void setCsMajorsum(Integer csMajorsum) {
        this.csMajorsum = csMajorsum;
    }

    public String getCsElse() {
        return csElse;
    }

    public void setCsElse(String csElse) {
        this.csElse = csElse == null ? null : csElse.trim();
    }

    public Integer getCsElsesum() {
        return csElsesum;
    }

    public void setCsElsesum(Integer csElsesum) {
        this.csElsesum = csElsesum;
    }

    public Integer getCsSum() {
        return csSum;
    }

    public void setCsSum(Integer csSum) {
        this.csSum = csSum;
    }

    public Integer getCsPaysum() {
        return csPaysum;
    }

    public void setCsPaysum(Integer csPaysum) {
        this.csPaysum = csPaysum;
    }

    public String getCsFeedback() {
        return csFeedback;
    }

    public void setCsFeedback(String csFeedback) {
        this.csFeedback = csFeedback == null ? null : csFeedback.trim();
    }

    public String getCsCallback() {
        return csCallback;
    }

    public void setCsCallback(String csCallback) {
        this.csCallback = csCallback;
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

    public String getCtHospital() {
        return ctHospital;
    }

    public void setCtHospital(String ctHospital) {
        this.ctHospital = ctHospital;
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
