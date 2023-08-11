package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;

@Component("smsservice")
public class SmsService implements MessageService{

    @PostConstruct//constructor metodu çağrıldıktan sonra
    public void init(){
        System.out.println("SmsService objesi oluşturuluyor");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("SmsService objesi imha edildi");
    }




//    //Random random = new Random()
//    @Autowired
//    private Random random;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir SMS servisiyim. Mesajınız: "+message.getMessage());

    }

    @Override
    public void saveMessage(Message message) {

    }

    //değişkenlerin değerlerini dışarıdan vermek isteriz
    @Value("${app.email}")
    private String email;
    @Value("${app.phone}")
    private String phone;

    public void printContact(){
        System.out.println("e-mail: "+email);
        System.out.println("phone number: "+phone);
    }

    //değişkenlerin değerlerini dışarıdan vermek için Properties classı
    @Autowired
    private Properties properties;
    public void printProperties(){
        System.out.println("contact e-mail: "+properties.getProperty("mymail"));
    }





}
