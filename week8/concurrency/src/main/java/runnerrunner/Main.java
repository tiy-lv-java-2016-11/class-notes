package runnerrunner;

/**
 * Created by jeff on 1/17/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main: " + Thread.currentThread().getName());
        Thread t1 = new Thread(new Runner(3000));
        Thread t2 = new Thread(new Runner(20));
        Thread t3 = new Thread(new Runner(1000));
        Thread t4 = new Thread(new Runner(100));
        Thread t5 = new Thread(new Runner(2000));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        System.out.println("Main method done");
    }
}
