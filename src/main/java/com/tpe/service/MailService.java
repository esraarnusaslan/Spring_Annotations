package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//bu classtan ileride ben bean isticem demek
//defaulttaki ismi mailService oluyor.
@Scope("prototype")//defaulttaki degeri Singleton dir.
public class MailService implements MessageService{



    @PostConstruct//cons methodu cagirildiktan hemen sonra(yani obje newlendikten hemen sonra)kullanmak istedigimiz
    //method varsa cagiriyor
    public void init(){
        System.out.println("mailservice objesi olusturuluyor..");
    }


    @PreDestroy//imha edilmeden hemen once
    public void destroy(){
        System.out.println("mailservice objesi imha edildi..");

    }



    //qualifer sadece autowired ile kullanilir



    //1) field injection
//    @Autowired//degiskenin degeri DI ile daha sonra enjekte edilecek demek
//    @Qualifier("fileRepository")//dbrepository i  kullan diyoruz ya da dbrepository diyebilirsin.
//    private Repository repo;



    //2) setter injection
//    private Repository repo;
//    @Autowired//repoyu setter ile enjekte et demek
//    @Qualifier("fileRepository")
//    public void setRepo(Repository repo) {
//        this.repo = repo;
//    }



    //3) constructor injection:daha guvenli, daha anlasilir, test etmesi daha kolay
    private Repository repo;
    @Autowired//classin sadece bir tane cons varsa bunu kullanmak zorunda degilsin
    public MailService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }










    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim. Mesajiniz: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {

        //reponun objesine ihtiyac var

        repo.save(message);

    }
}
