package singleton;

/**
 * 静态内部类实现单例模式
 *
 * @author harvey
 * @date 2020/12/4
 */
public class SingletonG{

    static class SingletonInstance{

        public static final SingletonG singleton = new SingletonG();
    }

    //提供外部能获取实例的方法
    public SingletonG getInstance() {

        return SingletonInstance.singleton;
    }

    //私有化构造器
    private SingletonG() {

    }
}
