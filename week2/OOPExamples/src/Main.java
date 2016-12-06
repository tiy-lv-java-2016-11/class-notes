import java.util.ArrayList;

/**
 * Created by jeff on 12/6/16.
 */
public class Main {

    public static void main(String[] args) {
        PitBull teddy = new PitBull("Teddy");
        teddy.makeSound();
        String choice = "1";
        int intChoice = Integer.parseInt(choice);

        ArrayList<Flyable> fliers = new ArrayList<>();
        Hawk hawk = new Hawk();
        fliers.add(hawk);
        fliers.add(new Eagle());

        for (Flyable flier : fliers){
            flier.fly();
        }


    }
}
