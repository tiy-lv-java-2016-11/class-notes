/**
 * Example car class
 */
public class Car {
    private String make;
    private String model;
    private int mileage;

    public Car(String make, String model){
        this.make = make;
        this.model = model;
        this.mileage = 0;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public int getMileage(){
        return this.mileage;
    }

    public void addMiles(int miles) throws Exception{
        if(miles < 0 ) {
            throw new Exception("You cannot pass in negative numbers");
        }

        this.mileage += miles;
    }

//    public void setMake(String make){
//        this.make = make;
//    }

//    public void setModel(String model){
//        this.model = model;
//    }

    public void makeNoise(){
        this.makeNoise("BEEP!");
    }

    public void makeNoise(String noise){
        System.out.println(noise);
    }
}
