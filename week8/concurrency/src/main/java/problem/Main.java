package problem;

/**
 * Created by jeff on 1/17/17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Problem p = new Problem();

        for(int i = 0; i < 100; i++){
            Thread t = new Thread(p);
            t.start();
        }

        Thread.sleep(5000);
        System.out.println(p.getHit());

    }

}
