/**
 * Created by jeff on 12/6/16.
 */
public class Hawk extends Bird implements Flyable {
    public Hawk() {
        this.name = "Hawk";
    }

    @Override
    public void fly(){
        System.out.println("flap flap flap");
    }
}
