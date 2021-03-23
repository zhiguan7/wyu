package com.wyu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async
public class MailSenderUtils {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    public void sendCode(String email, String context){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("测试验证码");
        mailMessage.setText("亲爱的用户， 您好！\n" +
                "\n" +
                "您的验证码是 "+ context+"\n" +
                "本验证码5分钟内有效，请及时输入\n" +
                "此邮件由系统自动发出,请勿直接回复。\n" +
                "感谢您的访问,祝您使用愉快!");

        mailMessage.setTo(email);
        mailMessage.setFrom("1405309321@qq.com");

        javaMailSender.send(mailMessage);
    }

    public void send(String email, String context){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("测试");
        mailMessage.setText(context);
        mailMessage.setTo(email);
        mailMessage.setFrom("1405309321@qq.com");

        javaMailSender.send(mailMessage);
    }


}
