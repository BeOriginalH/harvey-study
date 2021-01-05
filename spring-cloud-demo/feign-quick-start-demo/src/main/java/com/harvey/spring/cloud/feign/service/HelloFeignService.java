package com.harvey.spring.cloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author harvey
 * @date 2021/1/5
 */
@FeignClient(name = "github-client",
    url = "https://api.github.com")
public interface HelloFeignService{

    @RequestMapping(value = "/search/repositories",
        method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String queryStr);

}
