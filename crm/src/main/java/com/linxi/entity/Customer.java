package com.linxi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Customer implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer cId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String cName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_sex
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String cSex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_age
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer cAge;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_tel
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String cTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_project
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String cProject;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_place_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Timestamp cPlaceTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_remark
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String cRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_earnest
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer cEarnest;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_u_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer cUId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_source
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String cSource;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_message
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String cMessage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.c_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer cTypeId;

    /**
     * 用户名
     */
    private String uName;

    /**
     * 客户类型（状态）
     */
    private String cType;

    /**
     * 门诊
     */
    private String hospital;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_id
     *
     * @return the value of customer.c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getcId() {
        return cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_id
     *
     * @param cId the value for customer.c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcId(Integer cId) {
        this.cId = cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_name
     *
     * @return the value of customer.c_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getcName() {
        return cName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_name
     *
     * @param cName the value for customer.c_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_sex
     *
     * @return the value of customer.c_sex
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getcSex() {
        return cSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_sex
     *
     * @param cSex the value for customer.c_sex
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcSex(String cSex) {
        this.cSex = cSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_age
     *
     * @return the value of customer.c_age
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getcAge() {
        return cAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_age
     *
     * @param cAge the value for customer.c_age
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcAge(Integer cAge) {
        this.cAge = cAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_tel
     *
     * @return the value of customer.c_tel
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getcTel() {
        return cTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_tel
     *
     * @param cTel the value for customer.c_tel
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_project
     *
     * @return the value of customer.c_project
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getcProject() {
        return cProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_project
     *
     * @param cProject the value for customer.c_project
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcProject(String cProject) {
        this.cProject = cProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_place_time
     *
     * @return the value of customer.c_place_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Timestamp getcPlaceTime() {
        return cPlaceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_place_time
     *
     * @param cPlaceTime the value for customer.c_place_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcPlaceTime(Timestamp cPlaceTime) {
        this.cPlaceTime = cPlaceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_earnest
     *
     * @return the value of customer.c_earnest
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getcEarnest() {
        return cEarnest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_earnest
     *
     * @param cEarnest the value for customer.c_earnest
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcEarnest(Integer cEarnest) {
        this.cEarnest = cEarnest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_u_id
     *
     * @return the value of customer.c_u_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getcUId() {
        return cUId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_u_id
     *
     * @param cUId the value for customer.c_u_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcUId(Integer cUId) {
        this.cUId = cUId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_source
     *
     * @return the value of customer.c_source
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getcSource() {
        return cSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_source
     *
     * @param cSource the value for customer.c_source
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcSource(String cSource) {
        this.cSource = cSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.c_type_id
     *
     * @return the value of customer.c_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getcTypeId() {
        return cTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.c_type_id
     *
     * @param cTypeId the value for customer.c_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setcTypeId(Integer cTypeId) {
        this.cTypeId = cTypeId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    public String getcMessage() {
        return cMessage;
    }

    public void setcMessage(String cMessage) {
        this.cMessage = cMessage;
    }
}