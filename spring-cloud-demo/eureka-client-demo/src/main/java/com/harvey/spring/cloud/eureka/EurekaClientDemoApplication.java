package com.harvey.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class EurekaClientDemoApplication{

    public static void main(String[] args) {

        SpringApplication.run(EurekaClientDemoApplication.class, args);
    }

}
