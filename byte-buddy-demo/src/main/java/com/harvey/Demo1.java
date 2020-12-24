package com.harvey;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;

import java.io.File;
import java.io.IOException;

/**
 * @author harvey
 * @date 2020/5/9
 */
public class Demo1{



    public static void main(String[] args) throws IOException {

        DynamicType.Unloaded<Object> make = new ByteBuddy().subclass(Object.class).make();
        make.saveIn(new File("C:\\study_workspace\\harvey-study\\byte-buddy-demo\\src\\main\\java\\com\\harvey\\text"));

        File inject = make.inject(new File(""));

    }

}
