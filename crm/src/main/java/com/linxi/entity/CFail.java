package com.linxi.entity;

public class CFail {
    private Integer cfId;

    private Integer cfCId;

    private String cfHospital;

    private String cfCause;

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

    public String getCfHospital() {
        return cfHospital;
    }

    public void setCfHospital(String cfHospital) {
        this.cfHospital = cfHospital == null ? null : cfHospital.trim();
    }

    public String getCfCause() {
        return cfCause;
    }

    public void setCfCause(String cfCause) {
        this.cfCause = cfCause == null ? null : cfCause.trim();
    }
}