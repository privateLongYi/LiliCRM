package com.linxi.entity;

import java.io.Serializable;

public class RoleMenu implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.rm_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer rmId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.rm_r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer rmRId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.rm_m_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private Integer rmMId;

    /**
     * 菜单名称
     */
    private String mName;

    /**
     * 菜单路径
     */
    private String mUrl;

    /**
     * 菜单父级编号
     */
    private Integer mParentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role_menu
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.rm_id
     *
     * @return the value of role_menu.rm_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getRmId() {
        return rmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.rm_id
     *
     * @param rmId the value for role_menu.rm_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setRmId(Integer rmId) {
        this.rmId = rmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.rm_r_id
     *
     * @return the value of role_menu.rm_r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getRmRId() {
        return rmRId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.rm_r_id
     *
     * @param rmRId the value for role_menu.rm_r_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setRmRId(Integer rmRId) {
        this.rmRId = rmRId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.rm_m_id
     *
     * @return the value of role_menu.rm_m_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public Integer getRmMId() {
        return rmMId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.rm_m_id
     *
     * @param rmMId the value for role_menu.rm_m_id
     *
     * @mbg.generated Sat Aug 22 10:46:35 CST 2020
     */
    public void setRmMId(Integer rmMId) {
        this.rmMId = rmMId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public Integer getmParentId() {
        return mParentId;
    }

    public void setmParentId(Integer mParentId) {
        this.mParentId = mParentId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "rmId=" + rmId +
                ", rmRId=" + rmRId +
                ", rmMId=" + rmMId +
                ", mName='" + mName + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mParentId=" + mParentId +
                '}';
    }
}