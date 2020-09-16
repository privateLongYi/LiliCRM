package com.linxi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Follow implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.f_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer fId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.f_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer fCId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.f_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer fTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.f_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Timestamp fTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column follow.f_content
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String fContent;

    /**
     * 回访类型
     */
    private String fType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table follow
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.f_id
     *
     * @return the value of follow.f_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getfId() {
        return fId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column follow.f_id
     *
     * @param fId the value for follow.f_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setfId(Integer fId) {
        this.fId = fId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.f_c_id
     *
     * @return the value of follow.f_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getfCId() {
        return fCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column follow.f_c_id
     *
     * @param fCId the value for follow.f_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setfCId(Integer fCId) {
        this.fCId = fCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.f_type_id
     *
     * @return the value of follow.f_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getfTypeId() {
        return fTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column follow.f_type_id
     *
     * @param fTypeId the value for follow.f_type_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setfTypeId(Integer fTypeId) {
        this.fTypeId = fTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.f_time
     *
     * @return the value of follow.f_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Timestamp getfTime() {
        return fTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column follow.f_time
     *
     * @param fTime the value for follow.f_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setfTime(Timestamp fTime) {
        this.fTime = fTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column follow.f_content
     *
     * @return the value of follow.f_content
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getfContent() {
        return fContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column follow.f_content
     *
     * @param fContent the value for follow.f_content
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public Follow(Integer fId, Integer fCId, Integer fTypeId, Timestamp fTime, String fContent) {
        this.fId = fId;
        this.fCId = fCId;
        this.fTypeId = fTypeId;
        this.fTime = fTime;
        this.fContent = fContent;
    }

    public Follow() {

    }
}