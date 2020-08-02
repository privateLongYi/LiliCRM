package com.linxi.entity;

public class CReferral {
    private Integer crId;

    private Integer crCId;

    private String crOldHospital;

    private String crHospital;

    private String crCause;

    public Integer getCrId() {
        return crId;
    }

    public void setCrId(Integer crId) {
        this.crId = crId;
    }

    public Integer getCrCId() {
        return crCId;
    }

    public void setCrCId(Integer crCId) {
        this.crCId = crCId;
    }

    public String getCrOldHospital() {
        return crOldHospital;
    }

    public void setCrOldHospital(String crOldHospital) {
        this.crOldHospital = crOldHospital == null ? null : crOldHospital.trim();
    }

    public String getCrHospital() {
        return crHospital;
    }

    public void setCrHospital(String crHospital) {
        this.crHospital = crHospital == null ? null : crHospital.trim();
    }

    public String getCrCause() {
        return crCause;
    }

    public void setCrCause(String crCause) {
        this.crCause = crCause == null ? null : crCause.trim();
    }
}