import java.util.ArrayList;

/**
 * Created by jeff on 12/5/16.
 */
public class ForExample {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Lillian");
        names.add("Campos");
        names.add("Joey");

        int count = 0;
        while(count < names.size()){
            String name = names.get(count);
            System.out.println(name);
            count++;
        }

        for(String name : names){
            System.out.println(name);
        }

        int option = 0;
        while(option != 6){
            //option = input.nextLine();
            if(option == 1){
                System.out.println("You picked one");
            }
            else if(option == 6){
                System.out.println("Thank you for coming");
            }
        }

    }

}
