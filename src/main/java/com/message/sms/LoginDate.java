package com.message.sms;

public class LoginDate {
    private String userName;
    private String passworld;
    private String telnumber;

    public LoginDate() {
    }

    public LoginDate(String userName, String passworld, String telnumber) {
        this.userName = userName;
        this.passworld = passworld;
        this.telnumber = telnumber;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassworld() {
        return this.passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public String getTelnumber() {
        return this.telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }
}
