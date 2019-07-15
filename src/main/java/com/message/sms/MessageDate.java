package com.message.sms;

import java.util.Map;

public class MessageDate {
    private String spnumber;
    private String spnumpass;
    private Map<String, String> number;
    private String msg;

    public MessageDate() {
    }

    public MessageDate(String spnumber, String spnumpass, Map<String, String> number, String msg) {
        this.spnumber = spnumber;
        this.spnumpass = spnumpass;
        this.number = number;
        this.msg = msg;
    }

    public String getSpnumber() {
        return this.spnumber;
    }

    public void setSpnumber(String spnumber) {
        this.spnumber = spnumber;
    }

    public String getSpnumpass() {
        return this.spnumpass;
    }

    public void setSpnumpass(String spnumpass) {
        this.spnumpass = spnumpass;
    }

    public Map<String, String> getNumber() {
        return this.number;
    }

    public void setNumber(Map<String, String> number) {
        this.number = number;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}