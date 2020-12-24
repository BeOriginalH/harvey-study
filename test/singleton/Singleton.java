package singleton;

import java.io.Serializable;

/**
 * 饿汉式单例模式
 *
 * @author harvey
 * @date 2020/12/4
 */
public class Singleton implements Serializable{

    //初始化对象
    private static Singleton singleton = new Singleton();

    //提供外部能获取实例的方法
    public static Singleton getInstance() {

        return singleton;
    }

    private Object readResolve() {

        return getInstance();
    }

    //私有化构造器
    private Singleton() {

        if (singleton != null) {
            throw new RuntimeException("Singleton constructor is called ");
        }
    }
}
