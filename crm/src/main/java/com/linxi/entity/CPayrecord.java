package com.linxi.entity;

import java.util.Date;

public class CPayrecord {
    private Integer cpId;

    private Integer cpCsId;

    private Integer cpSum;

    private Date cpTime;

    private String cpProject;

    private String cpRemark;

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Integer getCpCsId() {
        return cpCsId;
    }

    public void setCpCsId(Integer cpCsId) {
        this.cpCsId = cpCsId;
    }

    public Integer getCpSum() {
        return cpSum;
    }

    public void setCpSum(Integer cpSum) {
        this.cpSum = cpSum;
    }

    public Date getCpTime() {
        return cpTime;
    }

    public void setCpTime(Date cpTime) {
        this.cpTime = cpTime;
    }

    public String getCpProject() {
        return cpProject;
    }

    public void setCpProject(String cpProject) {
        this.cpProject = cpProject == null ? null : cpProject.trim();
    }

    public String getCpRemark() {
        return cpRemark;
    }

    public void setCpRemark(String cpRemark) {
        this.cpRemark = cpRemark == null ? null : cpRemark.trim();
    }
}