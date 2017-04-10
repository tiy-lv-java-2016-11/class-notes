package threadchild;

/**
 * Created by jeff on 1/17/17.
 */
public class ThreadChild extends Thread {

    @Override
    public void run() {
        System.out.println("Doin my task: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with my task: " + Thread.currentThread().getName());
    }
}
