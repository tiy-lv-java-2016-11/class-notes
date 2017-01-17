package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jeff on 1/17/17.
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Executioner(3000));
        service.submit(new Executioner(20));
        service.submit(new Executioner(2000));
        service.submit(new Executioner(100));
        service.submit(new Executioner(1000));

        service.shutdown();
    }
}
