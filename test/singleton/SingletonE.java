package singleton;

/**
 * 双重检测锁实现懒汉式
 *
 * @author harvey
 * @date 2020/12/4
 */
public class SingletonE{

    //只做声明
    private static SingletonE singleton;

    //提供外部能获取实例的方法
    public SingletonE getInstance() {

        if (singleton == null) {
            synchronized (SingletonE.class) {
                if (singleton == null) {
                    singleton = new SingletonE();
                }
            }
        }
        return singleton;
    }

    //私有化构造器
    private SingletonE() {

    }
}
