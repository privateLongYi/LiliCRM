package com.linxi.entity;

import java.sql.Timestamp;

public class CFail {
    private Integer cfId;

    private Integer cfCId;

    private Timestamp cfTime;

    private String cfFeedback;

    private String cfCallback;

    /**
     *客户姓名
     */
    private String cName;

    /**
     *客户电话
     */
    private String cTel;

    /**
     *未成交门诊（预约门诊）
     */
    private String ctHospital;

    /**
     *未成交项目（客户报名项目）
     */
    private String cProject;

    /**
     *未成交定金（客户定金）
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

    public Integer getCfId() {
        return cfId;
    }

    public void setCfId(Integer cfId) {
        this.cfId = cfId;
    }

    public Integer getCfCId() {
        return cfCId;
    }

    public void setCfCId(Integer cfCId) {
        this.cfCId = cfCId;
    }

    public Timestamp getCfTime() {
        return cfTime;
    }

    public void setCfTime(Timestamp cfTime) {
        this.cfTime = cfTime;
    }

    public String getCfFeedback() {
        return cfFeedback;
    }

    public void setCfFeedback(String cfFeedback) {
        this.cfFeedback = cfFeedback;
    }

    public String getCfCallback() {
        return cfCallback;
    }

    public void setCfCallback(String cfCallback) {
        this.cfCallback = cfCallback;
    }
}