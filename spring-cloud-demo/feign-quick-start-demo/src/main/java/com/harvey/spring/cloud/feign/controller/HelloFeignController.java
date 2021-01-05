package com.harvey.spring.cloud.feign.controller;

import com.harvey.spring.cloud.feign.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harvey
 * @date 2021/1/5
 */
@RestController
public class HelloFeignController{

    @Autowired
    private HelloFeignService helloFeignService;

    @GetMapping(value = "/search/github")
    public String searchGithubRepoByStr(
        @RequestParam("str")
            String queryStr) {

        return helloFeignService.searchRepo(queryStr);
    }

}
