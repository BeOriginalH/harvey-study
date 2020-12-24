package singleton;

/**
 * 方法级别加锁的线程安全的懒汉式
 *
 * @author harvey
 * @date 2020/12/4
 */
public class SingletonC{

    //只做声明
    private static SingletonC singleton;

    //提供外部能获取实例的方法
    public synchronized SingletonC getInstance() {

        if (singleton == null) {
            singleton = new SingletonC();
        }
        return singleton;
    }

    //私有化构造器
    private SingletonC() {

    }
}
