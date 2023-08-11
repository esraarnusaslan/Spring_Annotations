package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration//bu classta config yapılacak
@ComponentScan("com.tpe")//bu packagedaki tüm componentları tara,default:com.tpe
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    private Environment environment;// Environment(Springin interfacei) application.properties
    // içindeki keylerin değerini okuyabilmemizi sağlar


    @Bean//random classından Spring bean oluşmasını sağlar.
    public Random random(){
        return new Random();
    }


    //value annotation ile yaptığımızı properties classı ile de yapabiliriz.

    @Bean
    public Properties properties(){
        Properties properties=new Properties();//hashtable extend eder
        properties.put("mymail",environment.getProperty("app.email"));
        //properties.put("mymail","app@gmail.com");
        return properties;
    }




}
