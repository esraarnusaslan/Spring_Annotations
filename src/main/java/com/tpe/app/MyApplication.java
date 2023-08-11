package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {

        Message message=new Message();
        message.setMessage("Spring ile çalışmak HARİKA olacak;)");

//config class oku
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
        //context: her bir componenttan ve beanlerden birer bean oluşturup, classın bir bağımlılığı var ise
        //bağımlılığı DI ile enjekte edip, içerisinde beanleri tutar


        //MessageService service =context.getBean(MailService.class);
//        MessageService service =context.getBean(MessageService.class);//Spring akıllı
//        service.sendMessage(message);

//        MessageService service=context.getBean("smsservice",MessageService.class);
//        service.sendMessage(message);
        //interfacein birden fazla impl var ise hangisini istediğimizi belirtmeliyiz.

        //messageları kalıcı hale getirelim
//        MessageService service=context.getBean(MailService.class);
//        service.sendMessage(message);
//        service.saveMessage(message);//DbRepoyu newlemedik,mailservice de newlenmedi

        //thirdparty classların objesini istersek
        //Random random = new Random();
//        Random random=context.getBean(Random.class);
//        System.out.println(random.nextInt(100));


        MessageService service1=context.getBean(MailService.class);
        MessageService service2=context.getBean(MailService.class);

        //Springte default scope:singleton;
        //sadece bir tane bean oluşturulur her yerde kullanılır
        // objenin yaşam döngüsünden tamamen Spring sorumludur

        //ihtiyaca göre scope:prototype;
        //her istendiğinde yeni bir bean oluşturur
        //objenin destroy/imhasından Spring sorumlu DEĞİLDİR

//        if(service1==service2){
//            System.out.println("Aynı referanslı objeler");
//            System.out.println(service1);
//            System.out.println(service2);
//        }else{
//            System.out.println("FARKLI referanslı objeler");
//            System.out.println(service1);
//            System.out.println(service2);
//        }

//        SmsService service3=context.getBean(SmsService.class);
//        service3.sendMessage(message);
//        service3.printContact();
//        service3.printProperties();



        //scope:prototype olan bir beani imha etmek için
        // context.getBeanFactory().destroyBean(service2);









        context.close();//beanler imha edilir.




    }
}
