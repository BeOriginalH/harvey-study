package com.harvey.validator.tools.validator;

import com.harvey.validator.tools.result.ApiResult;

/**
 * @author harvey
 * @date 2020/4/26
 */
public class NotNullValidator implements Validator{

    @Override
    public boolean validate(Object object) {

        if (object == null) {
            return false;
        }
        return true;
    }
}
