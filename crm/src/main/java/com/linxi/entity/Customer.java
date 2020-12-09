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

    private Timestamp cTime;

    private String cWx;

    /**
     * 报名项目
     */
    private String clProject;

    /**
     * 报名时间
     */
    private Timestamp clPlaceTime;

    /**
     * 备注
     */
    private String clRemark;

    /**
     * 报名费
     */
    private String clEntryFee;

    /**
     * 负责人编号
     */
    private Integer clUId;

    /**
     * 来源
     */
    private String clSource;

    /**
     * 症状信息
     */
    private String clMessage;

    /**
     * 状态编号
     */
    private Integer clTypeId;

    /**
     * 用户名
     */
    private String uName;

    /**
     * 客户状态
     */
    private String cType;

    /**
     * 预约门诊编号
     */
    private String hId;

    /**
     * 预约门诊名称
     */
    private String hName;

    /**
     * 预约时间
     */
    private Timestamp aTime;

    /**
     * 线索编号
     */
    private Integer clId;

    /**
     * 预约编号
     */
    private Integer aId;

    /**
     * 预约状态（预约已过，预约未过）
     */
    private String isDue;

    /**
     * 总成交金额
     */
    private Integer sSum;

    /**
     * 总支付金额
     */
    private Integer sPaysum;

    /**
     * 最早成交时间
     */
    private Timestamp sTime;

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

    public Timestamp getcTime() {
        return cTime;
    }

    public void setcTime(Timestamp cTime) {
        this.cTime = cTime;
    }

    public String getcWx() {
        return cWx;
    }

    public void setcWx(String cWx) {
        this.cWx = cWx;
    }

    public String getClProject() {
        return clProject;
    }

    public void setClProject(String clProject) {
        this.clProject = clProject;
    }

    public Timestamp getClPlaceTime() {
        return clPlaceTime;
    }

    public void setClPlaceTime(Timestamp clPlaceTime) {
        this.clPlaceTime = clPlaceTime;
    }

    public String getClRemark() {
        return clRemark;
    }

    public void setClRemark(String clRemark) {
        this.clRemark = clRemark;
    }

    public String getClEntryFee() {
        return clEntryFee;
    }

    public void setClEntryFee(String clEntryFee) {
        this.clEntryFee = clEntryFee;
    }

    public Integer getClUId() {
        return clUId;
    }

    public void setClUId(Integer clUId) {
        this.clUId = clUId;
    }

    public String getClSource() {
        return clSource;
    }

    public void setClSource(String clSource) {
        this.clSource = clSource;
    }

    public String getClMessage() {
        return clMessage;
    }

    public void setClMessage(String clMessage) {
        this.clMessage = clMessage;
    }

    public Integer getClTypeId() {
        return clTypeId;
    }

    public void setClTypeId(Integer clTypeId) {
        this.clTypeId = clTypeId;
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

    public String gethId() {
        return hId;
    }

    public void sethId(String hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public Timestamp getaTime() {
        return aTime;
    }

    public void setaTime(Timestamp aTime) {
        this.aTime = aTime;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getIsDue() {
        return isDue;
    }

    public void setIsDue(String isDue) {
        this.isDue = isDue;
    }

    public Integer getsSum() {
        return sSum;
    }

    public void setsSum(Integer sSum) {
        this.sSum = sSum;
    }

    public Integer getsPaysum() {
        return sPaysum;
    }

    public void setsPaysum(Integer sPaysum) {
        this.sPaysum = sPaysum;
    }

    public Timestamp getsTime() {
        return sTime;
    }

    public void setsTime(Timestamp sTime) {
        this.sTime = sTime;
    }

    public Customer() {
    }

    public Customer(Integer cId, String cName, String cSex, Integer cAge, String cTel, String cWx, Timestamp cTime) {
        this.cId = cId;
        this.cName = cName;
        this.cSex = cSex;
        this.cAge = cAge;
        this.cTel = cTel;
        this.cWx = cWx;
        this.cTime = cTime;
    }

}