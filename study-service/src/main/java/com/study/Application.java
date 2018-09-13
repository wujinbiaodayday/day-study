package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.study")
@ImportResource("classpath:study-service-dubbo.xml")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

}
