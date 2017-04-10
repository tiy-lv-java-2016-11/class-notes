package queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by jeff on 1/17/17.
 */
public class LetsQueue implements Runnable{

    private BlockingQueue<Integer> queue;

    public LetsQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        boolean done = false;

        while(!done || !queue.isEmpty()){
            System.out.println("There are currently: " + queue.size());
            System.out.println("I am patiently waiting for a number");
            try {
                System.out.println("I am taking: " + queue.take());
                Thread.sleep(250);
            } catch (InterruptedException e) {
                done = true;
            }
        }
    }
}
