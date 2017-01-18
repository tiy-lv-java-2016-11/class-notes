import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jeff on 1/18/17.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> people = createPeople();
        findFirstAdult(people);

    }

    public static List<Person> createPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("David", Person.Gender.MALE, "david@people.com", LocalDate.of(1995, 5, 10)));
        people.add(new Person("Sally", Person.Gender.FEMALE, "sally@people.com", LocalDate.of(1995, 7, 19)));
        people.add(new Person("Fred", Person.Gender.MALE, "fred@people.com", LocalDate.of(2001, 10, 31)));
        people.add(new Person("George", Person.Gender.MALE, "george@people.com", LocalDate.of(2015, 1, 11)));
        people.add(new Person("Annie", Person.Gender.FEMALE, "annie@people.com", LocalDate.of(1963, 6, 30)));

        return people;
    }

    public static void printEachName(List<Person> people){
        //For loop
        System.out.println("For Loop");
        for(Person person : people){
            System.out.println(person.getName());
        }

        //Stream
        System.out.println("Stream");
        people.stream().forEach(p -> System.out.println(p.getName()));
    }

    public static void printEachFemale(List<Person> people){
        //For Loop
        System.out.println("For loop");
        for(Person p : people){
            if(p.getGender() == Person.Gender.FEMALE){
                System.out.println(p.getName());
            }
        }

        //Stream
        System.out.println("Stream");
        people.stream().filter(p -> p.getGender() == Person.Gender.FEMALE)
                .forEach(p -> System.out.println(p.getName()));

    }

    public static void allAdults(List<Person> people){
        //For Loop
        System.out.println("***** FOR LOOP *****");
        boolean allAdult = true;
        for(Person p : people){
            if(p.getAge() < 18){
                allAdult = false;
            }
        }
        System.out.println("All are adults: " + allAdult);

        System.out.println("***** STREAM ****");
        boolean allAdults = people.stream().allMatch(p -> p.getAge() >= 18);
        System.out.println("All are adults: " + allAdults);
    }

    public static void getFirst2Adults(List<Person> people){
        //For loop
        System.out.println("***** FOR LOOP *****");
        int counter = 0;
        for(Person p : people){
            if(p.getAge() >= 18 && counter < 2){
                System.out.println(p.getName());
                counter++;
            }
        }

        System.out.println("**** STREAM ****");
        people.stream().filter(p -> p.getAge() >= 18).limit(2)
                .forEach(p -> System.out.println(p.getName()));

    }

    public static void countFemales(List<Person> people){
        people.stream().filter(p -> p.getGender() == Person.Gender.FEMALE).count();
    }

    public static void averageAge(List<Person> people){
        System.out.println("****** FOR LOOP ******");
        int totalAge = 0;
        int count = 0;
        for(Person p : people){
            totalAge += p.getAge();
            count++;
        }
        System.out.println("The average age is: " + (totalAge/count));

        System.out.println("***** STREAM *****");
        OptionalDouble optAvg = people.stream().mapToInt(Person::getAge).average();
        double avg = optAvg.getAsDouble();
    }

    public static void getNamesList(List<Person> people){
        System.out.println("******* FOR LOOP ******");
        List<String> names = new ArrayList<>();
        for(Person p : people){
            names.add(p.getName());
        }

        List<String> foo = people.stream().filter(p -> p.getGender() == Person.Gender.FEMALE).map(p -> p.getName()).collect(Collectors.toList());
    }

    public static void makeNameMap(List<Person> people){
        System.out.println("****** FOR LOOP *******");
        Map<String, Person> nameMap = new HashMap<>();
        for(Person p : people){
            nameMap.put(p.getName(), p);
        }

        System.out.println("***** STREAM *******");
        Map<String, Person> map2 = people.stream().collect(Collectors.toMap(p -> p.getName(), p -> p));
    }

    public static void groupByAge(List<Person> people){
        System.out.println("**** FOR LOOP ***");
        Map<Integer, List<Person>>  ageGroups = new HashMap<>();
        for(Person p : people){
            List<Person> personList;
            if(ageGroups.containsKey(p.getAge())){
                personList = ageGroups.get(p.getAge());
            }
            else{
                personList = new ArrayList<>();
            }

            personList.add(p);
            ageGroups.put(p.getAge(), personList);
        }

        System.out.println("**** STREAM ****");
        ageGroups = people.stream().collect(Collectors.groupingBy(p -> p.getAge()));
    }

    public static void findFirstAdult(List<Person> people){
        Person person = new Person("Annie", Person.Gender.FEMALE, "annie@people.com", LocalDate.of(1963, 6, 30));
        Optional<Person> optPerson = people.stream().filter(p -> p.getAge() >= 180).findFirst();
        Person foo = optPerson.orElseGet(() -> person);

        String bar = "bar";
    }

    public static void sortedPeople(List<Person> people){
        people.stream().sorted(Comparator.comparing(Person::getName).reversed()).collect(Collectors.toList());
    }


    public void distinctNumbers(){
        List<Integer> ints = Arrays.asList(1,2,3,4,5,2,3);
        ints.stream().distinct().collect(Collectors.toList());
    }

    public void avgNumber(){
        List<Integer> ints = Arrays.asList(1,2,3,4,5,2,3);

        ints.stream().mapToInt(Integer::valueOf).average();
    }

    public void minNumber(){
        List<Integer> ints = Arrays.asList(1,2,3,4,5,2,-3);

        ints.stream().mapToInt(Integer::valueOf).reduce(100000, Integer::min);
        ints.stream().mapToInt(Integer::valueOf).min();
    }

    public void squareNumbers(){
        List<Integer> ints = Arrays.asList(1,2,3,4,5,2,3);

        ints.stream().mapToInt(Integer::valueOf).reduce(0, (a, b) -> a*a + b*b);
    }

    public void sortNumbers(){
        List<Integer> ints = Arrays.asList(1,2,3,4,5,-2,3);

        ints.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    }

    public void readFile() throws IOException {
        Files.lines(Paths.get("names.txt")).map(n -> n.length()).collect(Collectors.toList());
    }
}
