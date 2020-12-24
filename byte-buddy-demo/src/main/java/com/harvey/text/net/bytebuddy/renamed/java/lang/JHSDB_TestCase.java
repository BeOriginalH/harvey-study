package com.harvey.text.net.bytebuddy.renamed.java.lang;

/**
 * @author harvey
 * @date 2020/9/22
 */
public class JHSDB_TestCase{

    static class Test{

        static ObjectHolder staticObj = new ObjectHolder();

        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {

            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }

    }

    private static class ObjectHolder{

    }

    public static void main(String[] args) {

        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }

}
