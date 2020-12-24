package com.harvey.customer.web.controller;

import com.harvey.customer.api.service.CustomerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harvey
 * @date 2020/1/6
 */
@RestController
@RequestMapping("/customer")
public class CustomerController{

    @Reference(version = "1.0.0",group = "customer")
    private CustomerService customerService;

    @GetMapping(value = "/findCustomerName")
    public String findCustomerName() {

        return customerService.getCustomerName(1L);
    }

}
