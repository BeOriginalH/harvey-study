package com.harvey.customer;


import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class CustomerServiceApplication{

    public static void main(String[] args) {
//        initFlowRule();
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    private static void initFlowRule() {
        FlowRule flowRule = new FlowRule();
        //针对具体的方法限流
        flowRule.setResource("com.harvey.customer.api.service.CustomerService:getCustomerName(java.lang.Long)");
        flowRule.setCount(10);//限流阈值 qps=10
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);//限流阈值类型（QPS 或并发线程数）
        flowRule.setLimitApp("default");//流控针对的调用来源，若为 default 则不区分调用来源
        // 流量控制手段（直接拒绝、Warm Up、匀速排队）
        flowRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));
    }

}
