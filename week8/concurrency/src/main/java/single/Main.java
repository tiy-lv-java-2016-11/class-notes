package single;

/**
 * Created by jeff on 1/17/17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Task t = new Task();

        for(int i = 0; i < 10; i++){
            t.task();
        }
    }

}
