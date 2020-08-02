package com.linxi.entity;

public class User {
    private Integer uId;

    private String uName;

    private String password;

    private Integer uRoleId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getuRoleId() {
        return uRoleId;
    }

    public void setuRoleId(Integer uRoleId) {
        this.uRoleId = uRoleId;
    }
}