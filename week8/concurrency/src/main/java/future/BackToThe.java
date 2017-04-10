package future;

import java.util.concurrent.Callable;

/**
 * Created by jeff on 1/17/17.
 */
public class BackToThe implements Callable<String> {

    private int timeout = 0;

    public BackToThe(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": We don't need roads");
        Thread.sleep(timeout);
        return Thread.currentThread().getName() + ": Future";
    }
}
