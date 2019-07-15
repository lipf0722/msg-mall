package com.message.sms;


public class SMSRequest {
    private String access_token;
    private String timestamp;
    private String auth_token;
    private String state;
    private String sign;
    private MessageDate messageDate;

    public SMSRequest() {
    }

    public SMSRequest(String access_token, String timestamp, String auth_token, String state) {
        this.access_token = access_token;
        this.timestamp = timestamp;
        this.auth_token = auth_token;
        this.state = state;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuth_token() {
        return this.auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public MessageDate getMessageDate() {
        return this.messageDate;
    }

    public void setMessageDate(MessageDate messageDate) {
        this.messageDate = messageDate;
    }
}
