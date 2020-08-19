package com.linxi.entity;

public class CArrive {
    private Integer caId;

    private Integer caCtId;

    private String caCallback;

    /**
     *客户姓名
     */
    private String cName;

    /**
     *客户电话
     */
    private String cTel;

    /**
     *未到店门诊（预约门诊）
     */
    private String ctHospital;

    /**
     *未到店项目（客户报名项目）
     */
    private String cProject;

    /**
     *未到店定金（客户定金）
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

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public Integer getCaCtId() {
        return caCtId;
    }

    public void setCaCtId(Integer caCtId) {
        this.caCtId = caCtId;
    }

    public String getCaCallback() {
        return caCallback;
    }

    public void setCaCallback(String caCallback) {
        this.caCallback = caCallback == null ? null : caCallback.trim();
    }
}