package future;

import java.util.concurrent.*;

/**
 * Created by jeff on 1/17/17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> c1 = new BackToThe(2000);
        Callable<String> c2 = new BackToThe(5000);

        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> task1 = service.submit(c1);
        Future<String> task2 = service.submit(c2);

//        while(!task1.isDone() || !task2.isDone()){
//            System.out.println("Task1: " + (task1.isDone() ? "done" : "running"));
//            System.out.println("Task2: " + (task2.isDone() ? "done" : "running"));
//            Thread.sleep(100);
//        }

        System.out.println(task1.get());
        System.out.println(task2.get());

        service.shutdown();
    }
}
