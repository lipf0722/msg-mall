package com.message.mail;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.message.util.ReturnMsgCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import javax.mail.internet.MimeMessage;
/**
 * 发送邮件
 */
@RestController
@Slf4j
public class MailController {
    @Value("${spring.mail.username}")
    private String username;
    @Autowired
    JavaMailSender mailSender;//自动注入
    /**
     * {"mailTo":"","mailSubject":"邮件主题","mailText":"邮件正文"}
     * @param json
     * @return
     * {
     *     "msg": "操作成功",
     *     "code": 0,
     *     "time": "2019-04-23 10:15:54"
     * }
     */
    @PostMapping("ganinfo/sendEmail")
    public JSONObject sendEmail(@RequestBody String json) {
        JSONObject resObj=new JSONObject();
        try {
            JSONObject obj=JSONUtil.parseObj(json);
            if(obj.containsKey("mailTo") && obj.containsKey("mailSubject") && obj.containsKey("mailText")){
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                //有true发送附件  没有true 参数纯文本的邮件
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
                message.setFrom(username);//设置发信人，发信人需要和spring.mail.username配置的一样否则报错
                message.setTo(obj.getStr("mailTo"));				//设置收信人
                message.setSubject(obj.getStr("mailSubject"));	//设置主题
                message.setText(obj.getStr("mailText"));  	//第二个参数true表示使用HTML语言来编写邮件
                resObj.put(ReturnMsgCode.code,ReturnMsgCode.rightCode);
                resObj.put(ReturnMsgCode.msg,ReturnMsgCode.rightMsg);
                resObj.put(ReturnMsgCode.time, DateUtil.now());
                mailSender.send(mimeMessage);
                log.info(DateUtil.now()+"发件人："+username+"--收件人："+obj.getStr("mailTo")+"--邮件主题："+obj.getStr("mailSubject")+"---邮件正文："+obj.getStr("mailText")+"发送成功!");
            }else{
                resObj.put(ReturnMsgCode.code,ReturnMsgCode.illegalCode);
                resObj.put(ReturnMsgCode.msg,ReturnMsgCode.illegalMsg);
                resObj.put(ReturnMsgCode.time, DateUtil.now());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resObj.put(ReturnMsgCode.code,ReturnMsgCode.errCode);
            resObj.put(ReturnMsgCode.msg,ReturnMsgCode.errMsg);
            resObj.put(ReturnMsgCode.time, DateUtil.now());
        }
        return resObj;
    }
    
}