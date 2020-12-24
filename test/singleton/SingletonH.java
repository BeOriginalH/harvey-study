package singleton;

/**
 * 枚举实现单例模式
 *
 * @author harvey
 * @date 2020/12/4
 */
public class SingletonH{

    private enum SingletonEnum{

        INSTANCE;

        private final SingletonH instance;

        SingletonEnum() {
            instance = new SingletonH();
        }

        private SingletonH getInstance() {

            return instance;
        }

    }

    //提供外部能获取实例的方法
    public static SingletonH getInstance() {

        return SingletonEnum.INSTANCE.getInstance();
    }

    //私有化构造器
    private SingletonH() {

    }
}
