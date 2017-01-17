package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by jeff on 1/17/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
        LetsQueue q = new LetsQueue(queue);

        Thread t = new Thread(q);
        t.start();

        Thread.sleep(1000);

        for(int i = 0; i < 100; i++){
            System.out.println("Adding number: " + i);
            queue.put(i);
            Thread.sleep(100);
        }

        t.interrupt();
    }
}
