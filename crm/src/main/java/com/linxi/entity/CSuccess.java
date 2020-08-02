package com.linxi.entity;

public class CSuccess {
    private Integer csId;

    private Integer csCId;

    private String csHospital;

    private String csMajor;

    private Integer csMajorsum;

    private String csElse;

    private Integer csElsesum;

    private Integer csSum;

    private Integer csPaysum;

    private String csFeedback;

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
    }

    public Integer getCsCId() {
        return csCId;
    }

    public void setCsCId(Integer csCId) {
        this.csCId = csCId;
    }

    public String getCsHospital() {
        return csHospital;
    }

    public void setCsHospital(String csHospital) {
        this.csHospital = csHospital == null ? null : csHospital.trim();
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
}