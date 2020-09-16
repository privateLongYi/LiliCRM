package com.linxi.entity;

import java.io.Serializable;

public class Referral implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referral.r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer rId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referral.r_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer rCId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referral.r_fail_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer rFailHId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referral.r_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer rHId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referral.r_message
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String rMessage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referral.r_cause
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String rCause;

    /**
     * 客户名称
     */
    private String cName;

    /**
     * 未成交门诊名称
     */
    private String failHName;

    /**
     * 新预约门诊名称
     */
    private String hName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table referral
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referral.r_id
     *
     * @return the value of referral.r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getrId() {
        return rId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referral.r_id
     *
     * @param rId the value for referral.r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setrId(Integer rId) {
        this.rId = rId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referral.r_c_id
     *
     * @return the value of referral.r_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getrCId() {
        return rCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referral.r_c_id
     *
     * @param rCId the value for referral.r_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setrCId(Integer rCId) {
        this.rCId = rCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referral.r_fail_h_id
     *
     * @return the value of referral.r_fail_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getrFailHId() {
        return rFailHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referral.r_fail_h_id
     *
     * @param rFailHId the value for referral.r_fail_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setrFailHId(Integer rFailHId) {
        this.rFailHId = rFailHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referral.r_h_id
     *
     * @return the value of referral.r_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getrHId() {
        return rHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referral.r_h_id
     *
     * @param rHId the value for referral.r_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setrHId(Integer rHId) {
        this.rHId = rHId;
    }

    public String getrMessage() {
        return rMessage;
    }

    public void setrMessage(String rMessage) {
        this.rMessage = rMessage;
    }

    public String getrCause() {
        return rCause;
    }

    public void setrCause(String rCause) {
        this.rCause = rCause;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getFailHName() {
        return failHName;
    }

    public void setFailHName(String failHName) {
        this.failHName = failHName;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public Referral() {
    }

    public Referral(Integer rId, Integer rCId, Integer rFailHId, Integer rHId, String rMessage, String rCause) {
        this.rId = rId;
        this.rCId = rCId;
        this.rFailHId = rFailHId;
        this.rHId = rHId;
        this.rMessage = rMessage;
        this.rCause = rCause;
    }
}