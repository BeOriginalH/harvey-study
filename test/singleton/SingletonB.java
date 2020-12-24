package singleton;

/**
 * 线程不安全的懒汉式
 *
 * @author harvey
 * @date 2020/12/4
 */
public class SingletonB{

    //只做声明
    private static SingletonB singleton;

    //提供外部能获取实例的方法
    public SingletonB getInstance() {

        //存在线程安全问题
        if (singleton == null) {
            singleton = new SingletonB();
        }
        return singleton;
    }

    //私有化构造器
    private SingletonB() {

    }
}
