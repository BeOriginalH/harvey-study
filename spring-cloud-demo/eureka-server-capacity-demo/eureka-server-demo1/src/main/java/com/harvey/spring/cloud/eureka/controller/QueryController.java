package com.harvey.spring.cloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harvey
 * @date 2021/1/5
 */
@RestController
@RequestMapping(value = "/query")
public class QueryController{

    @Autowired
    EurekaClientConfigBean eurekaClientConfigBean;

    @GetMapping("/eureka-server")
    public Object getEurekaServerUrl() {

        return eurekaClientConfigBean.getServiceUrl();
    }

}
