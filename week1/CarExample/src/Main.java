/**
 * Created by jeff on 11/29/16.
 */
public class Main {

    public static void main(String[] args) {
        Car infiniti = new Car("Infiniti", "G35");

        Car honda = new Car("Honda","Civic");

        try {
            honda.addMiles(10);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(infiniti.getMake() + " " + infiniti.getModel());
        infiniti.makeNoise();

//        User bob = new User();
//
//        bob.setName("Bob Cratchet");
//        bob.setEmail("bob@bob.bob");
    }
}
