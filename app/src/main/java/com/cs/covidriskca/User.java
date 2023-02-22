package com.cs.covidriskca;

public class User {
    private String username;
    private String password;
    private String DermindPassword;
    private String sex;
    private String picPath;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDermindPassword() {
        return DermindPassword;
    }

    public void setDermindPassword(String DermindPassword) {
        this.DermindPassword = DermindPassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", DetermindPassword='" + DermindPassword + '\'' +
                ", sex='" + sex + '\'' +
                ", picPath='" + picPath + '\'' +
                '}';
    }
}
