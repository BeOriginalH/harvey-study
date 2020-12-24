package thread;

/**
 * @author harvey
 * @date 2020/10/19
 */
public class Test1{

    static class Father{

        public int a = 1;

        public Father(){

            a = 2;
            test();
        }

        public void test(){

            System.out.println("father has "+a);
        }
    }

    static class Son extends  Father{

        public int a = 3;
        public Son(){
            a = 4;
            test();
        }

        public void test() {

            System.out.println("son has " + a);
        }

    }

    public static void main(String[] args) {
        Father father =  new Son();

        System.out.println("gay has "+father.a);
    }

}
