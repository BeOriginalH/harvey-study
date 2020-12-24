package com.harvey.customer.service;

import com.harvey.customer.api.service.CustomerService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author harvey
 * @date 2020/1/6
 */
@Service(version = "1.0.0",interfaceClass = CustomerService.class,group = "customer")
public class CustomerServiceImpl implements CustomerService{

    @Override
    public String getCustomerName(Long customerId) {

        return "test customer";
    }
}
