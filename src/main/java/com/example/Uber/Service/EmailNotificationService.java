package com.example.Uber.Service;

import com.example.Uber.Interface.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Primary
@Component
public class EmailNotificationService implements Notification {

@Autowired
private JavaMailSender javaMailSender;



    @Override
    @Async
    public void sendnotification() {
// shubham.Raghav.63699@gmail.com

        System.out.println(Thread.currentThread());
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
//        simpleMailMessage.setTo("satyamcchauhan47@gmail.com","manuthakur8859@gmail.com","garimaraghav8@gmail.com");
//        simpleMailMessage.setText("you have upto 80% off dididididididijiiiiii");
//        simpleMailMessage.setSubject("Booking confirmed");
//        javaMailSender.send(simpleMailMessage);
  }
}
