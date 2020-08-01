package com.linxi.entity;

import java.sql.Date;

public class Customertransaction {
    private Integer cid;

    private String cname;

    private String ctel;

    private String cproject;

    private Date cregistrationtime;

    private String cearnest;

    private String cusp;

    private Integer cuspid;

    private Date cappointmenttime;

    private String chospital;

    private Integer carrive;

    private Integer ctransaction;

    private Integer cstatus;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel == null ? null : ctel.trim();
    }

    public String getCproject() {
        return cproject;
    }

    public void setCproject(String cproject) {
        this.cproject = cproject == null ? null : cproject.trim();
    }

    public Date getCregistrationtime() {
        return cregistrationtime;
    }

    public void setCregistrationtime(Date cregistrationtime) {
        this.cregistrationtime = cregistrationtime;
    }

    public String getCearnest() {
        return cearnest;
    }

    public void setCearnest(String cearnest) {
        this.cearnest = cearnest == null ? null : cearnest.trim();
    }

    public String getCusp() {
        return cusp;
    }

    public void setCusp(String cusp) {
        this.cusp = cusp == null ? null : cusp.trim();
    }

    public Integer getCuspid() {
        return cuspid;
    }

    public void setCuspid(Integer cuspid) {
        this.cuspid = cuspid;
    }

    public Date getCappointmenttime() {
        return cappointmenttime;
    }

    public void setCappointmenttime(Date cappointmenttime) {
        this.cappointmenttime = cappointmenttime;
    }

    public String getChospital() {
        return chospital;
    }

    public void setChospital(String chospital) {
        this.chospital = chospital == null ? null : chospital.trim();
    }

    public Integer getCarrive() {
        return carrive;
    }

    public void setCarrive(Integer carrive) {
        this.carrive = carrive;
    }

    public Integer getCtransaction() {
        return ctransaction;
    }

    public void setCtransaction(Integer ctransaction) {
        this.ctransaction = ctransaction;
    }

    public Integer getCstatus() {
        return cstatus;
    }

    public void setCstatus(Integer cstatus) {
        this.cstatus = cstatus;
    }
}