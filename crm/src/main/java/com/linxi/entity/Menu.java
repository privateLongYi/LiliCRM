package com.linxi.entity;

import java.io.Serializable;

public class Menu implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.m_id
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    private Integer mId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.m_name
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    private String mName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.m_url
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    private String mUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.m_parent_id
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    private Integer mParentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.m_type
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    private String mType;

    /**
     * 子级数量
     */
    private Integer childCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table menu
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.m_id
     *
     * @return the value of menu.m_id
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public Integer getmId() {
        return mId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.m_id
     *
     * @param mId the value for menu.m_id
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public void setmId(Integer mId) {
        this.mId = mId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.m_name
     *
     * @return the value of menu.m_name
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public String getmName() {
        return mName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.m_name
     *
     * @param mName the value for menu.m_name
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.m_url
     *
     * @return the value of menu.m_url
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public String getmUrl() {
        return mUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.m_url
     *
     * @param mUrl the value for menu.m_url
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.m_parent_id
     *
     * @return the value of menu.m_parent_id
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public Integer getmParentId() {
        return mParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.m_parent_id
     *
     * @param mParentId the value for menu.m_parent_id
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public void setmParentId(Integer mParentId) {
        this.mParentId = mParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.m_type
     *
     * @return the value of menu.m_type
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public String getmType() {
        return mType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.m_type
     *
     * @param mType the value for menu.m_type
     *
     * @mbg.generated Mon Sep 07 19:43:46 CST 2020
     */
    public void setmType(String mType) {
        this.mType = mType;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Menu() {
    }

    public Menu(Integer mId, String mName, String mUrl, Integer mParentId, String mType) {
        this.mId = mId;
        this.mName = mName;
        this.mUrl = mUrl;
        this.mParentId = mParentId;
        this.mType = mType;
    }
}