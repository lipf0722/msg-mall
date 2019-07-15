package com.message.sms;


public class ConstantConfigUtil {
    //发送短信
    private static  String sendMessageUrl = "http://sms.xjdelikai.com:8080/ApiSend/messageSendApi";
    //发送语音
    private static  String sendVoiceUrl = "http://sms.xjdelikai.com:8080/ApiSend/voiceSendApi";
    //回调查询
    private static String sendDateUrl = "http://sms.xjdelikai.com:8080/ApiSend/smsSendDateApi";


    public static String getSendDateUrl() {
        return sendDateUrl;
    }

    public static void setSendDateUrl(String sendDateUrl) {
        ConstantConfigUtil.sendDateUrl = sendDateUrl;
    }



    private static String send_secret="xjbmfw";//发送密匙

    public static String getSendVoiceUrl() {
        return sendVoiceUrl;
    }

    public static void setSendVoiceUrl(String sendVoiceUrl) {
        ConstantConfigUtil.sendVoiceUrl = sendVoiceUrl;
    }

    public static String getSendMessageUrl() {
        return sendMessageUrl;
    }

    public static void setSendMessageUrl(String sendMessageUrl) {
        ConstantConfigUtil.sendMessageUrl = sendMessageUrl;
    }

    public static String getSend_secret() {
        return send_secret;
    }
    public static void setSend_secret(String send_secret) {
        ConstantConfigUtil.send_secret = send_secret;
    }
}
