package com.linxi.entity;

import java.io.Serializable;

public class Atype implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column atype.at_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer atId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column atype.at_type
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String atType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table atype
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column atype.at_id
     *
     * @return the value of atype.at_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getAtId() {
        return atId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column atype.at_id
     *
     * @param atId the value for atype.at_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setAtId(Integer atId) {
        this.atId = atId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column atype.at_type
     *
     * @return the value of atype.at_type
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getAtType() {
        return atType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column atype.at_type
     *
     * @param atType the value for atype.at_type
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setAtType(String atType) {
        this.atType = atType;
    }
}