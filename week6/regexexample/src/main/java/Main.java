import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jeff on 1/4/17.
 */
public class Main {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d+) (years old)", Pattern.DOTALL);
        Matcher m = p.matcher("I am 99 years old. You are 25 years old");

        // Matches entire string
        if(m.matches()){
            System.out.println("I matched");
        }

        // Finds matches
        while(m.find()){
            System.out.println("I found");
            System.out.println(m.groupCount());
            for(int i = 0; i <= m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
//            System.out.println(m.group(1) + " years young");
            System.out.format("(%s) %s-%s", m.group(1), m.group(2), m.group(3));
        }


    }
}
