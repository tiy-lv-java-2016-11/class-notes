package threadchild;

/**
 * Created by jeff on 1/17/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main: " + Thread.currentThread().getName());
        Thread t1 = new ThreadChild();
        Thread t2 = new ThreadChild();
        Thread t3 = new ThreadChild();
        Thread t4 = new ThreadChild();
        Thread t5 = new ThreadChild();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        System.out.println("Main method done");
    }
}
