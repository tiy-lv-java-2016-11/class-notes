package anonymous;

/**
 * Created by jeff on 12/14/16.
 */
public class AnonymousClassExample {

    public static void main(String[] args) {
        Reptile gator = new Reptile() {
            @Override
            public void makeNoise() {
                System.out.println("Croak");
            }
        };

        gator.makeNoise();
    }
}
