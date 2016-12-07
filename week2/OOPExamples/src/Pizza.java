import java.util.ArrayList;

/**
 * Created by jeff on 12/6/16.
 */
public class Pizza {
    private ArrayList<String> toppings;
    private String name;
    public static int SIZE = 14;

    public Pizza(String name, ArrayList<String> toppings){
        this.toppings = toppings;
        this.name = name;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Pizza createSupremePizza(){
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("Pepperoni");
        toppings.add("Bell Pepper");
        toppings.add("Sausage");
        toppings.add("Tomato");
        toppings.add("Onions");
        Pizza supreme = new Pizza("Supreme", toppings);

        return supreme;
    }

    public static void main(String[] args) {
        System.out.println("HELLO WORLD");
        String choice = "2";
        int newChoice = Integer.parseInt(choice);

//        Integer foo = 1;
//        int newChoice = foo.parseInt(choice);

//        ArrayList<String> toppings = new ArrayList<>();
//        toppings.add("Pepperoni");
//        Pizza pepperoni = new Pizza("Pepperoni Pizza", toppings);
//
//        pepperoni.createSupremePizza();
//
        Pizza supreme = Pizza.createSupremePizza();
    }


}
