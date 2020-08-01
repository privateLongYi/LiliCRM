package com.linxi.entity;

public class Customertransfer {
    private Integer ctid;

    private Integer ctcid;

    private String ctusp;

    private Integer ctuspid;

    private String ctoldhospital;

    private String ctoldfeedback;

    private String ctnewhospital;

    private String ctnewfeedback;

    private String ctarrive;

    private String cttransaction;

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public Integer getCtcid() {
        return ctcid;
    }

    public void setCtcid(Integer ctcid) {
        this.ctcid = ctcid;
    }

    public String getCtusp() {
        return ctusp;
    }

    public void setCtusp(String ctusp) {
        this.ctusp = ctusp == null ? null : ctusp.trim();
    }

    public Integer getCtuspid() {
        return ctuspid;
    }

    public void setCtuspid(Integer ctuspid) {
        this.ctuspid = ctuspid;
    }

    public String getCtoldhospital() {
        return ctoldhospital;
    }

    public void setCtoldhospital(String ctoldhospital) {
        this.ctoldhospital = ctoldhospital == null ? null : ctoldhospital.trim();
    }

    public String getCtoldfeedback() {
        return ctoldfeedback;
    }

    public void setCtoldfeedback(String ctoldfeedback) {
        this.ctoldfeedback = ctoldfeedback == null ? null : ctoldfeedback.trim();
    }

    public String getCtnewhospital() {
        return ctnewhospital;
    }

    public void setCtnewhospital(String ctnewhospital) {
        this.ctnewhospital = ctnewhospital == null ? null : ctnewhospital.trim();
    }

    public String getCtnewfeedback() {
        return ctnewfeedback;
    }

    public void setCtnewfeedback(String ctnewfeedback) {
        this.ctnewfeedback = ctnewfeedback == null ? null : ctnewfeedback.trim();
    }

    public String getCtarrive() {
        return ctarrive;
    }

    public void setCtarrive(String ctarrive) {
        this.ctarrive = ctarrive == null ? null : ctarrive.trim();
    }

    public String getCttransaction() {
        return cttransaction;
    }

    public void setCttransaction(String cttransaction) {
        this.cttransaction = cttransaction == null ? null : cttransaction.trim();
    }
}