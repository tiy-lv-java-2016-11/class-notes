package single;

/**
 * Created by jeff on 1/17/17.
 */
public class Task {

    public void task() throws InterruptedException {
        System.out.println("Doin my task");
        Thread.sleep(1000);
        System.out.println("Done with my task");
    }
}
