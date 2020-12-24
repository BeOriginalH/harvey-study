package singleton;

import java.lang.reflect.Constructor;

/**
 * @author harvey
 * @date 2020/12/7
 */

public class SingletonTest{

    public static void main(String[] args) throws Exception {

        SingletonH singletonH = SingletonH.getInstance();

        Class<SingletonH> singletonFClass = (Class<SingletonH>) Class.forName("singleton.SingletonH");
        Constructor<SingletonH> declaredConstructor = singletonFClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        SingletonH singletonHReflect = declaredConstructor.newInstance();

        System.out.println(singletonHReflect);
        System.out.println(singletonH);
        System.out.println(singletonHReflect == singletonH);
    }
}
