package anonymous;

/**
 * Created by jeff on 12/14/16.
 */
public class AnonymousFunctionExample {

    public static void main(String[] args) {
        sayHello();

        Runnable r2 = () -> {
            System.out.println("Hello from lambda");
        };

        r2.run();
    }

    static void sayHello(){
        System.out.println("Hello from method!");
    }
}
