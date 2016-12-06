/**
 * Created by jeff on 12/6/16.
 */
public class Dog extends Mammal {
    private String breed = "";

    public Dog(String name){
        this.name = name;
    }

    @Override
    public void makeSound(){
        System.out.println("Bark!");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public static Dog createPitbull(){
        Dog dog = new Dog("Mr Worldwide");
        dog.setBreed("Pitbull");

        return dog;
    }
}
