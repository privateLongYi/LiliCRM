package com.linxi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Operating implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operating.op_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer opId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operating.op_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer opCId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operating.op_u_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer opUId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operating.op_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String opName;

    private String opContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column operating.op_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Timestamp opTime;

    /**
     *用户名
     */
    private String uName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table operating
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operating.op_id
     *
     * @return the value of operating.op_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getOpId() {
        return opId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operating.op_id
     *
     * @param opId the value for operating.op_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operating.po_c_id
     *
     * @return the value of operating.po_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getOpCId() {
        return opCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operating.po_c_id
     *
     * @param opCId the value for operating.op_c_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setOpCId(Integer opCId) {
        this.opCId = opCId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operating.op_u_id
     *
     * @return the value of operating.op_u_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getOpUId() {
        return opUId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operating.op_u_id
     *
     * @param opUId the value for operating.op_u_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setOpUId(Integer opUId) {
        this.opUId = opUId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operating.op_name
     *
     * @return the value of operating.op_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getOpName() {
        return opName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operating.op_name
     *
     * @param opName the value for operating.op_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpContent() {
        return opContent;
    }

    public void setOpContent(String opContent) {
        this.opContent = opContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column operating.op_time
     *
     * @return the value of operating.op_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Timestamp getOpTime() {
        return opTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column operating.op_time
     *
     * @param opTime the value for operating.op_time
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setOpTime(Timestamp opTime) {
        this.opTime = opTime;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Operating(Integer opCId, Integer opUId, String opName, String opContent) {
        this.opCId = opCId;
        this.opUId = opUId;
        this.opName = opName;
        this.opContent = opContent;
    }

    public Operating() {

    }
}