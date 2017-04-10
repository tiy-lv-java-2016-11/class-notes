package problem;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by jeff on 1/17/17.
 */
public class Problem implements Runnable{

    private int hit = 0;
    private AtomicInteger hit2 = new AtomicInteger();
    private LongAdder hit3 = new LongAdder();

    public synchronized void increment(){
        System.out.println("Running increment: " + Thread.currentThread().getName());
        int number = this.hit;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number += 1;
        this.hit = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        increment();
        hit2.incrementAndGet();
        hit3.increment();
    }

    public int getHit() {
        return hit;
    }

    public int getHit2() {
        return hit2.get();
    }

    public int getHit3() {
        return hit3.intValue();
    }
}
