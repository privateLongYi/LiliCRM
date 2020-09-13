package com.linxi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Success implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success.s_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer sId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success.s_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer sCId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success.s_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer sHId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success.s_message
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String sMessage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success.s_sum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer sSum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success.s_paysum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer sPaysum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success.s_remark
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String sRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success.s_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Timestamp sTime;

    /**
     * 客户名称
     */
    private String cName;

    /**
     * 客户电话
     */
    private String cTel;

    /**
     * 门诊
     */
    private String hospital;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table success
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column success.s_id
     *
     * @return the value of success.s_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getsId() {
        return sId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column success.s_id
     *
     * @param sId the value for success.s_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setsId(Integer sId) {
        this.sId = sId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column success.s_c_id
     *
     * @return the value of success.s_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getsCId() {
        return sCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column success.s_c_id
     *
     * @param sCId the value for success.s_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setsCId(Integer sCId) {
        this.sCId = sCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column success.s_h_id
     *
     * @return the value of success.s_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getsHId() {
        return sHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column success.s_h_id
     *
     * @param sHId the value for success.s_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setsHId(Integer sHId) {
        this.sHId = sHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column success.s_sum
     *
     * @return the value of success.s_sum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getsSum() {
        return sSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column success.s_sum
     *
     * @param sSum the value for success.s_sum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setsSum(Integer sSum) {
        this.sSum = sSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column success.s_paysum
     *
     * @return the value of success.s_paysum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getsPaysum() {
        return sPaysum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column success.s_paysum
     *
     * @param sPaysum the value for success.s_paysum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setsPaysum(Integer sPaysum) {
        this.sPaysum = sPaysum;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getsMessage() {
        return sMessage;
    }

    public void setsMessage(String sMessage) {
        this.sMessage = sMessage;
    }

    public String getsRemark() {
        return sRemark;
    }

    public void setsRemark(String sRemark) {
        this.sRemark = sRemark;
    }

    public Timestamp getsTime() {
        return sTime;
    }

    public void setsTime(Timestamp sTime) {
        this.sTime = sTime;
    }

    public Success() {
    }

    public Success(Integer sId, Integer sCId, Integer sHId, String sMessage, Integer sSum, Integer sPaysum, String sRemark) {
        this.sId = sId;
        this.sCId = sCId;
        this.sHId = sHId;
        this.sMessage = sMessage;
        this.sSum = sSum;
        this.sPaysum = sPaysum;
        this.sRemark = sRemark;
    }
}