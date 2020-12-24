package singleton;

/**
 * 防止重排序的懒汉式
 *
 * @author harvey
 * @date 2020/12/4
 */
public class SingletonF{

    //只做声明
    private static volatile SingletonF singleton;

    //提供外部能获取实例的方法
    public  static SingletonF getInstance() {

        if (singleton == null) {
            synchronized (SingletonF.class) {
                if (singleton == null) {
                    singleton = new SingletonF();
                }
            }
        }
        return singleton;
    }

    //私有化构造器
    private SingletonF() {

    }
}
