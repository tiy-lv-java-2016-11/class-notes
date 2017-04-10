package executorservice;

/**
 * Created by jeff on 1/17/17.
 */
public class Executioner implements Runnable {
    private int timeout;

    public Executioner(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public void run() {
        System.out.println("Doin my task: " + Thread.currentThread().getName());
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with my task: " + Thread.currentThread().getName());
    }
}
