import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jeff on 11/30/16.
 */
public class Player extends Character{
    private String weapon;
    private String location;
    private Scanner input = new Scanner(System.in);
    private ArrayList<String> weapons = new ArrayList<>();
    private HashMap<String, String> locations = new HashMap<>();

    public Player(){
        weapons.add("sword");
        weapons.add("mace");
        weapons.add("axe");

        locations.put("forest", "Now entering the spooky old forest...");
        locations.put("cave", "Now enter the cave of the dark side of the force");
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void chooseName(){
        System.out.println("What is your name foolish traveler?");
        setName(this.input.nextLine());
        System.out.println("Welcome, " + getName());
    }

    public void chooseWeapon() {
        while(this.weapon == null){
            //Ask for what weapon
            System.out.println("Choose your weapon: Mace or Sword");
            String weapon = input.nextLine();

            if(this.weapons.contains(weapon.toLowerCase())) {
                System.out.format("A %s is a fine choice.\n", weapon);
                this.weapon = weapon;
            }

        }
    }

    public void chooseLocation() {
        while(this.location == null) {
            System.out.println("Choose your location [forest/cave]");
            String location = input.nextLine().toLowerCase();

            if(locations.containsKey(location)){
                System.out.println(locations.get(location));
                this.location = location;
            }
        }
    }
}
