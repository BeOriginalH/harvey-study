package singleton;

/**
 * 代码块级别加锁的懒汉式
 *
 * @author harvey
 * @date 2020/12/4
 */
public class SingletonD{

    //只做声明
    private static SingletonD singleton;

    //提供外部能获取实例的方法
    public SingletonD getInstance() {

        if (singleton == null) {
            synchronized (SingletonD.class) {
                singleton = new SingletonD();
            }
        }
        return singleton;
    }

    //私有化构造器
    private SingletonD() {

    }
}
