package com.linxi.entity;

public class CReferral {
    private Integer crId;

    private Integer crCtId;

    private String crOldHospital;

    private String crHospital;

    private String crCause;

    private String cfFeedback;

    private String cfCallback;

    public Integer getCrId() {
        return crId;
    }

    public void setCrId(Integer crId) {
        this.crId = crId;
    }

    public Integer getCrCtId() {
        return crCtId;
    }

    public void setCrCtId(Integer crCtId) {
        this.crCtId = crCtId;
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