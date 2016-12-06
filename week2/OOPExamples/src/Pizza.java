import java.util.ArrayList;

/**
 * Created by jeff on 12/6/16.
 */
public class Pizza {
    private ArrayList<String> toppings;
    private String name;

    public Pizza(String name, ArrayList<String> toppings){
        this.toppings = toppings;
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
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("Pepperoni");
        Pizza pepperoni = new Pizza("Pepperoni Pizza", toppings);

        pepperoni.createSupremePizza();

        Pizza supreme = Pizza.createSupremePizza();
    }


}
