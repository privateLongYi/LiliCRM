package com.linxi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Clue implements Serializable {

    private Integer clId;

    private Integer clCId;

    private String clProject;

    private Timestamp clPlaceTime;

    private String clRemark;

    private Integer clEarnest;

    private Integer clUId;

    private String clSource;

    private String clMessage;

    private Integer clTypeId;

    private Integer clInvalid;

    private static final long serialVersionUID = 1L;

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public Integer getClCId() {
        return clCId;
    }

    public void setClCId(Integer clCId) {
        this.clCId = clCId;
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

    public Integer getClEarnest() {
        return clEarnest;
    }

    public void setClEarnest(Integer clEarnest) {
        this.clEarnest = clEarnest;
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

    public Integer getClInvalid() {
        return clInvalid;
    }

    public void setClInvalid(Integer clInvalid) {
        this.clInvalid = clInvalid;
    }

    public Clue() {
    }

    public Clue(Integer clId, Integer clCId, String clProject, Timestamp clPlaceTime, String clRemark, Integer clEarnest, Integer clUId, String clSource, String clMessage, Integer clTypeId, Integer clInvalid) {
        this.clId = clId;
        this.clCId = clCId;
        this.clProject = clProject;
        this.clPlaceTime = clPlaceTime;
        this.clRemark = clRemark;
        this.clEarnest = clEarnest;
        this.clUId = clUId;
        this.clSource = clSource;
        this.clMessage = clMessage;
        this.clTypeId = clTypeId;
        this.clInvalid = clInvalid;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "clId=" + clId +
                ", clCId=" + clCId +
                ", clProject='" + clProject + '\'' +
                ", clPlaceTime=" + clPlaceTime +
                ", clRemark='" + clRemark + '\'' +
                ", clEarnest=" + clEarnest +
                ", clUId=" + clUId +
                ", clSource='" + clSource + '\'' +
                ", clMessage='" + clMessage + '\'' +
                ", clTypeId=" + clTypeId +
                ", clInvalid=" + clInvalid +
                '}';
    }
}