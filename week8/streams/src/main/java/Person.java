import java.time.LocalDate;
import java.time.Period;

/**
 * Created by jeff on 1/18/17.
 */
public class Person {
    public enum Gender{
        MALE, FEMALE
    }

    private String name;
    private Gender gender;
    private String emailAddress;
    private LocalDate birthdate;

    public Person(String name, Gender gender, String emailAddress, LocalDate birthdate) {
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge(){
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
