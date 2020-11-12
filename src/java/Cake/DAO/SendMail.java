/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DAO;

import java.io.Serializable;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author tatha
 */
public class SendMail implements Serializable{
    public void sendText(String fname, String lname,String phone, String email, String message) throws AddressException, MessagingException {
    Properties mailServerProperties;
    Session getMailSession;
    MimeMessage mailMessage;
 
    // Step1: setup Mail Server
    mailServerProperties = System.getProperties();
    mailServerProperties.put("mail.smtp.port", "587");
    mailServerProperties.put("mail.smtp.auth", "true");
    mailServerProperties.put("mail.smtp.starttls.enable", "true");
 
    // Step2: get Mail Session
    getMailSession = Session.getDefaultInstance(mailServerProperties, null);
    mailMessage = new MimeMessage(getMailSession);
 
    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("duyttse130241@fpt.edu.vn")); //Thay abc bằng địa chỉ người nhận
 
    // Bạn có thể chọn CC, BCC
//    generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail
 
 
    mailMessage.setSubject("Demo send gmail from Java");
    mailMessage.setText("Tên Khách Hàng: "+ fname + " " +lname+ "\n "
            + "Số Điện Thoại: "+phone+ "\n "
                    + "Email: "+email+ "\n "
                        + "Thông Tin: "+ message,"UTF-8");
 
    // Step3: Send mail
    Transport transport = getMailSession.getTransport("smtp");
 
    // Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail của bạn
    transport.connect("smtp.gmail.com", "tathaiduy@gmail.com", "tathaiduy"); 
    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
    transport.close();
  }
}
