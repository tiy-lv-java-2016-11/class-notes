import java.util.Scanner;

/**
 * Created by jeff on 11/30/16.
 */
public class TextAdventure {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome traveler");

        Player player = new Player();
        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

//        int x = 0;
//        while(x < 5){
//            System.out.println("Hello");
//            x++;
//        }
//        String foo = "Hello world";
//        for(int x = 0; x < foo.length(); x++){
//            System.out.println(foo.charAt(x));
//        }

    }
}
