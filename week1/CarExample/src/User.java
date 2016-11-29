/**
 * Created by jeff on 11/29/16.
 */
public class User {
    private String email;
    private String name;
    private String firstName;
    private String lastName;

    public String getEmail(){
        return this.email;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }
}
