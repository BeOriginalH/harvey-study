package com.harvey.validator.tools.model;

import com.harvey.validator.tools.annotation.NotNull;

/**
 * @author harvey
 * @date 2020/4/26
 */
public class User{

    @NotNull(message = "sss")
    private String name;

}
