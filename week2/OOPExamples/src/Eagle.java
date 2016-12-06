/**
 * Created by jeff on 12/6/16.
 */
public class Eagle extends Bird implements Flyable {
    public Eagle(){
        this.name = "Eagle";
    }

    @Override
    public void fly() {
        System.out.println("Awesome!");
    }
}
