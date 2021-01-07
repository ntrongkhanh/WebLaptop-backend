package com.weblaptop.backend.mailConfig;

import com.weblaptop.backend.models.ENTITY.OrdersEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    public void sendConfirmMail(JavaMailSender emailSender, String userEmail, String token) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(userEmail);
        message.setSubject("Confirm account mail");
        message.setFrom("trongkhanhvip1@gmail.com");
        message.setText("Bạn đã đăng ký tài khoản trong web WAVI bằng email này."
                + "\nĐể xác nhận tài khoản, vui long truy cập link:"
                + "http://localhost:4200/confirm-account?token=" + token + "&email=" + userEmail);
        emailSender.send(message);
    }

    public void sendOrderMail(JavaMailSender emailSender, OrdersEntity ordersEntity) {
        SimpleMailMessage message = new SimpleMailMessage();

        String productList = "";
        for (int i = 0; i < ordersEntity.getCartDetailEntities().size(); i++) {
            productList = productList + "-" + ordersEntity.getCartDetailEntities().get(i).getProductEntity().getName() + " x " +
                    ordersEntity.getCartDetailEntities().get(i).getAmount() + "\n" +
                    "Giá: " + ordersEntity.getCartDetailEntities().get(i).getProductEntity().getPrice() + " x " +
                    ordersEntity.getCartDetailEntities().get(i).getAmount() + " = " +
                    ordersEntity.getCartDetailEntities().get(i).getTotalPrice() + " vnđ\n";

        }
        message.setTo(ordersEntity.getUser().getEmail());
        message.setSubject("Xác nhận đơn hàng #" + ordersEntity.getOrderCode());
        message.setFrom("trongkhanhvip1@gmail.com");
        message.setText("Cảm ơn khách hàng " + ordersEntity.getUser().getName() + " đã đặt hàng tại WAVI\n" +
                "Thông tin đơn hàng: #" + ordersEntity.getOrderCode() +"\n"+
                "Tên khách hàng: " + ordersEntity.getUser().getName() +"\n"+
                "Email: " + ordersEntity.getUser().getEmail() +"\n"+
                "Số điện thoại: " + ordersEntity.getPhone() +"\n"+
                "Mã đơn hàng: " + ordersEntity.getOrderCode() +"\n"+
                "Địa chỉ giao: " + ordersEntity.getAddress() +"\n"+
                "Danh sách sản phẩm: " +"\n"+
                productList +"\n"+
                "Tổng giá: "+ordersEntity.getTotalPrice()+" vnđ.");
        emailSender.send(message);
    }
}
