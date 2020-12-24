package com.harvey.validator.tools;

import com.harvey.validator.tools.result.ApiResult;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author harvey
 * @date 2020/4/26
 */
public class ValidatorProcesser{

    public ApiResult process(Object object)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {

            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {

                Class<? extends Annotation> aClass = annotation.getClass();
                Method method = aClass.getMethod("", null);
                Object invoke = method.invoke(object, null);
            }

        }
        return null;
    }

}
