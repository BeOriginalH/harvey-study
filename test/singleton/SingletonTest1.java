package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author harvey
 * @date 2020/12/7
 */

public class SingletonTest1{

    public static void main(String[] args) throws Exception {

        Singleton singleton = Singleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(singleton);

        File file = new File("tempFile");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton singletonSerialize = (Singleton) ois.readObject();

        System.out.println(singleton);
        System.out.println(singletonSerialize);
        System.out.println(singleton == singletonSerialize);

    }
}
