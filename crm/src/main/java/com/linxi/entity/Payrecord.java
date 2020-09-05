package com.linxi.entity;

import java.io.Serializable;
import java.util.Date;

public class Payrecord implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payrecord.pay_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer payId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payrecord.pay_s_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer paySId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payrecord.pay_sum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String paySum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payrecord.pay_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Date payTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payrecord.pay_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer payTypeId;

    /**
     * 客户名称
     */
    private String cName;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table payrecord
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payrecord.pay_id
     *
     * @return the value of payrecord.pay_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getPayId() {
        return payId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payrecord.pay_id
     *
     * @param payId the value for payrecord.pay_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payrecord.pay_s_id
     *
     * @return the value of payrecord.pay_s_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getPaySId() {
        return paySId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payrecord.pay_s_id
     *
     * @param paySId the value for payrecord.pay_s_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setPaySId(Integer paySId) {
        this.paySId = paySId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payrecord.pay_sum
     *
     * @return the value of payrecord.pay_sum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getPaySum() {
        return paySum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payrecord.pay_sum
     *
     * @param paySum the value for payrecord.pay_sum
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setPaySum(String paySum) {
        this.paySum = paySum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payrecord.pay_time
     *
     * @return the value of payrecord.pay_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payrecord.pay_time
     *
     * @param payTime the value for payrecord.pay_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payrecord.pay_type_id
     *
     * @return the value of payrecord.pay_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getPayTypeId() {
        return payTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payrecord.pay_type_id
     *
     * @param payTypeId the value for payrecord.pay_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setPayTypeId(Integer payTypeId) {
        this.payTypeId = payTypeId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}