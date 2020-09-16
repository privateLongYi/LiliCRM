package com.linxi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Appointment implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.a_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer aId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.a_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer aCId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.a_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Timestamp aTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.a_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer aHId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment.a_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer aTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table appointment
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */

    /**
     * 客户名称
     */
    private String cName;

    /**
     * 预约门诊
     */
    private String hospital;

    /**
     * 预约类型
     */
    private String aType;

    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.a_id
     *
     * @return the value of appointment.a_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getaId() {
        return aId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.a_id
     *
     * @param aId the value for appointment.a_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setaId(Integer aId) {
        this.aId = aId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.a_c_id
     *
     * @return the value of appointment.a_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getaCId() {
        return aCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.a_c_id
     *
     * @param aCId the value for appointment.a_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setaCId(Integer aCId) {
        this.aCId = aCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.a_time
     *
     * @return the value of appointment.a_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Timestamp getaTime() {
        return aTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.a_time
     *
     * @param aTime the value for appointment.a_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setaTime(Timestamp aTime) {
        this.aTime = aTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.a_h_id
     *
     * @return the value of appointment.a_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getaHId() {
        return aHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.a_h_id
     *
     * @param aHId the value for appointment.a_h_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setaHId(Integer aHId) {
        this.aHId = aHId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment.a_type_id
     *
     * @return the value of appointment.a_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getaTypeId() {
        return aTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment.a_type_id
     *
     * @param aTypeId the value for appointment.a_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setaTypeId(Integer aTypeId) {
        this.aTypeId = aTypeId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public Appointment() {
    }

    public Appointment(Integer aId, Integer aCId, Timestamp aTime, Integer aHId, Integer aTypeId) {
        this.aId = aId;
        this.aCId = aCId;
        this.aTime = aTime;
        this.aHId = aHId;
        this.aTypeId = aTypeId;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "aId=" + aId +
                ", aCId=" + aCId +
                ", aTime=" + aTime +
                ", aHId=" + aHId +
                ", aTypeId=" + aTypeId +
                ", cName='" + cName + '\'' +
                ", hospital='" + hospital + '\'' +
                ", aType='" + aType + '\'' +
                '}';
    }
}