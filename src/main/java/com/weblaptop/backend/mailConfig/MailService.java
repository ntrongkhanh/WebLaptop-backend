package com.weblaptop.backend.mailConfig;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    public void sendConfirmMail(JavaMailSender emailSender, String userEmail,String token){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(userEmail);
        message.setSubject("Confirm account mail");
        message.setFrom("muoiad23@gmail.com");
        message.setText("Bạn đã đăng ký tài khoản trong web WAVI bằng email này."
                 +   "\nĐể xác nhận tài khoản, vui long truy cập link:"
                + "http://localhost:4200/confirm-account?token=" + token + "&email=" + userEmail);
        emailSender.send(message);
    }
}
