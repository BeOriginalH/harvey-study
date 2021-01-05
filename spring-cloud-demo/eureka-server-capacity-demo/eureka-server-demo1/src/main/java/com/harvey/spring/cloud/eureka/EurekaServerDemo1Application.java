package com.harvey.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerDemo1Application{

    public static void main(String[] args) {

        SpringApplication.run(EurekaServerDemo1Application.class, args);
    }

}
