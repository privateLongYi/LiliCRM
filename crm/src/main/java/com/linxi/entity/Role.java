package com.linxi.entity;

import java.io.Serializable;

public class Role implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer rId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.r_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private String rName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.r_id
     *
     * @return the value of role.r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getrId() {
        return rId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.r_id
     *
     * @param rId the value for role.r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setrId(Integer rId) {
        this.rId = rId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.r_name
     *
     * @return the value of role.r_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public String getrName() {
        return rName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.r_name
     *
     * @param rName the value for role.r_name
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setrName(String rName) {
        this.rName = rName;
    }
}