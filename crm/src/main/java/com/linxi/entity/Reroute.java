package com.linxi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reroute implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reroute.re_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer reId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reroute.re_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer reCId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reroute.re_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer reHId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reroute.re_last_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Timestamp reLastTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reroute.re_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Timestamp reTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reroute.re_cause
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String reCause;

    /**
     * 客户名称
     */
    private String cName;

    /**
     * 门诊名称
     */
    private String hName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reroute
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reroute.re_id
     *
     * @return the value of reroute.re_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getReId() {
        return reId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reroute.re_id
     *
     * @param reId the value for reroute.re_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setReId(Integer reId) {
        this.reId = reId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reroute.re_c_id
     *
     * @return the value of reroute.re_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getReCId() {
        return reCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reroute.re_c_id
     *
     * @param reCId the value for reroute.re_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setReCId(Integer reCId) {
        this.reCId = reCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reroute.re_h_id
     *
     * @return the value of reroute.re_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getReHId() {
        return reHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reroute.re_h_id
     *
     * @param reHId the value for reroute.re_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setReHId(Integer reHId) {
        this.reHId = reHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reroute.re_last_time
     *
     * @return the value of reroute.re_last_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Timestamp getReLastTime() {
        return reLastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reroute.re_last_time
     *
     * @param reLastTime the value for reroute.re_last_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setReFirstTime(Timestamp reLastTime) {
        this.reLastTime = reLastTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reroute.re_time
     *
     * @return the value of reroute.re_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Timestamp getReTime() {
        return reTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reroute.re_time
     *
     * @param reTime the value for reroute.re_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setReTime(Timestamp reTime) {
        this.reTime = reTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reroute.re_cause
     *
     * @return the value of reroute.re_cause
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getReCause() {
        return reCause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reroute.re_cause
     *
     * @param reCause the value for reroute.re_cause
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setReCause(String reCause) {
        this.reCause = reCause;
    }

    public void setReLastTime(Timestamp reLastTime) {
        this.reLastTime = reLastTime;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public Reroute() {
    }

    public Reroute(Integer reCId, Integer reHId, Timestamp reLastTime, Timestamp reTime, String reCause) {
        this.reCId = reCId;
        this.reHId = reHId;
        this.reLastTime = reLastTime;
        this.reTime = reTime;
        this.reCause = reCause;
    }
}