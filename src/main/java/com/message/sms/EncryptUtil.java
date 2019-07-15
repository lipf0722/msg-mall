package com.message.sms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class EncryptUtil {
    public EncryptUtil() {
    }

    public static String encrypByMd5To32(String context) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(context.getBytes());
            byte[] encryContext = md.digest();
            StringBuffer buf = new StringBuffer("");

            for(int offset = 0; offset < encryContext.length; ++offset) {
                int i = encryContext[offset];
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException var6) {
            var6.printStackTrace();
            return context;
        }
    }

    public static String encrypByPattern(String context) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(context.getBytes());
            byte[] encryContext = md.digest();
            StringBuffer buf = new StringBuffer("");

            for(int offset = 0; offset < encryContext.length; ++offset) {
                int i = encryContext[offset];
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException var6) {
            var6.printStackTrace();
            return context;
        }
    }

    public static String computeByDatePhp() {
        Long date = (new Date()).getTime();
        String timestamp = String.valueOf(date);
        int length = timestamp.length();
        return timestamp.substring(0, length - 3);
    }

    public static String signByGenerateToString(String access_token, String timestamp, String spnumber, String state, String token_secret) {
        String context = access_token + timestamp + spnumber + token_secret + state + ConstantConfigUtil.getSend_secret();
        return encrypByPattern(context);
    }
}
