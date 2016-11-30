import java.util.Scanner;

/**
 * Created by jeff on 11/30/16.
 */
public class Player {
    private String name;
    private String weapon;
    private String location;
    private Scanner input = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.name = this.input.nextLine();
        System.out.println("Welcome, " + this.name);
    }

    public void chooseWeapon() {

        while(this.weapon == null){
            //Ask for what weapon
            System.out.println("Choose your weapon: Mace or Sword");
            String weapon = input.nextLine();

            if(weapon.equalsIgnoreCase("sword")
                    || weapon.equalsIgnoreCase("mace")){
                System.out.format("A %s is a fine choice.\n", weapon);
                this.weapon = weapon;
            }
        }
    }

    public void chooseLocation() {
        while(this.location == null) {
            System.out.println("Choose your location [forest/cave]");
            String location = input.nextLine();

            if (location.equalsIgnoreCase("forest")) {
                System.out.println("Now entering spooky forest...");
                this.location = location;
            } else if (location.equalsIgnoreCase("cave")) {
                System.out.println("Now entering cave strong with the dark side of the force");
                this.location = location;
            }
        }
    }
}
