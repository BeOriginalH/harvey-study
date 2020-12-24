package com.harvey.order.service;

import com.harvey.order.api.service.OrderService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author harvey
 * @date 2020/1/6
 */
@Service(version = "1.0.0",interfaceClass = OrderService.class,group = "order")
public class OrderServiceImpl implements OrderService{

    @Override
    public String findOrderName(Long orderId) {

        return "test order";
    }
}
