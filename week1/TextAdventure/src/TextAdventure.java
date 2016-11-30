import java.util.Scanner;

/**
 * Created by jeff on 11/30/16.
 */
public class TextAdventure {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome traveler");

        Player player1 = new Player();
        player1.chooseName();
        player1.chooseWeapon();
        player1.chooseLocation();
    }
}
