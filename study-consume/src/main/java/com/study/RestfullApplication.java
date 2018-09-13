package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.study")
@ImportResource("classpath:/study-consume-dubbo.xml")
@EnableSwagger2
public class RestfullApplication {

    public  static void main(String[] args){
        SpringApplication.run(RestfullApplication.class,args);
    }


}
