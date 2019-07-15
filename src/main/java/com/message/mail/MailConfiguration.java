package com.message.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 这里这么做的目的是，JavaMailSender自动注入失败，在这里手动注入
 */
@Configuration
public class MailConfiguration {
    @Value("${spring.mail.username}")
    private String username;
    //邮箱的临时授权码，不是真正的邮箱密码
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.host}")
    private String host;
    @Bean
    public JavaMailSenderImpl JavaMailSender(){
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(host);
    mailSender.setUsername(username);
    mailSender.setPassword(password);
     return  mailSender;
}
}