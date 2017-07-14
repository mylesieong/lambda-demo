import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class DemoLambda{

    static List<Person> roster;

    static {
        roster = new ArrayList<Person>();
        roster.add(
            new Person("Alex", 18, Person.PERSON_MALE, "somewhere over the rainbow", Person.SERVER_CAIRO)
        );
        roster.add(
            new Person("Ben", 19, Person.PERSON_MALE, "somewhere over the rainbow", Person.SERVER_LONDON)
        );
        roster.add(
            new Person("Cathy", 20, Person.PERSON_FEMALE, "somewhere over the rainbow", Person.SERVER_PARIS)
        );
        roster.add(
            new Person("Doris", 21, Person.PERSON_FEMALE, "somewhere over the rainbow", Person.SERVER_PARIS)
        );
        roster.add(
            new Person("Elaine", 20, Person.PERSON_FEMALE, "somewhere over the rainbow", Person.SERVER_PARIS)
        );
        roster.add(
            new Person("Frank", 19, Person.PERSON_MALE, "somewhere over the rainbow", Person.SERVER_CAIRO)
        );
        roster.add(
            new Person("Gary", 18, Person.PERSON_MALE, "somewhere over the rainbow", Person.SERVER_CAIRO)
        );
        roster.add(
            new Person("Henry", 32, Person.PERSON_MALE, "somewhere over the rainbow", Person.SERVER_CAIRO)
        );
        roster.add(
            new Person("Iris", 15, Person.PERSON_FEMALE, "somewhere over the rainbow", Person.SERVER_LONDON)
        );
        roster.add(
            new Person("Jerry", 12, Person.PERSON_MALE, "somewhere over the rainbow", Person.SERVER_CAIRO)
        );
        roster.add(
            new Person("Ken", 48, Person.PERSON_MALE, "somewhere over the rainbow", Person.SERVER_LONDON)
        );
    }

    public static void main(String[] args){

        roster
            .stream()
            .filter(p -> p.getAge() >= 15)
            .forEach(p -> System.out.println(p));

        roster
            .stream()
            .filter(p -> p.getAge() >= 18)
            .forEach(p -> System.out.println(p));

        roster
            .stream()
            .filter(p -> p.getAge() < 15)
            .forEach(p -> System.out.println(p));

        roster
            .stream()
            .filter(p -> p.getAge() < 18)
            .forEach(p -> System.out.println(p));

        roster
            .stream()
            .filter(p -> p.getAge() >= 15 && p.getAge() < 18)
            .forEach(p -> System.out.println(p));

        roster
            .stream()
            .filter(p -> p.getAge() >= 18 && p.getGender() == Person.PERSON_MALE)
            .forEach(p -> System.out.println(p));

        roster
            .stream()
            .filter(p -> p.getGender() == Person.PERSON_FEMALE)
            .forEach(p -> System.out.println(p));

        roster
            .stream()
            .filter(p -> p.getServer() == Person.SERVER_LONDON)
            .forEach(p -> p.refreshAge());

        roster
            .stream()
            .filter(p -> p.getServer() == Person.SERVER_CAIRO)
            .forEach(p -> p.refreshAddress());

    }

    public static class Person {

        final static int PERSON_MALE = 0;
        final static int PERSON_FEMALE = 1;

        final static int SERVER_LONDON = 0;
        final static int SERVER_PARIS = 1;
        final static int SERVER_CAIRO = 2;

        String name;
        int age;
        int gender;
        String address;
        int server;

        public Person (String name, int age, int gender, String address, int server) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.address = address;
            this.server = server;
        }

        public String getName() {
           return this.name;
        } 

        public int getAge() {
            return this.age;
        }
    
        public int getGender() {
            return this.gender;
        }

        public String getAddress() {
            return this.address;
        }

        public int getServer() {
            return this.server;
        }

        public void refreshAge(){
            //stub
            System.out.println("stub in refreshAge:" + toString());
        }

        public void refreshAddress(){
            //stub
            System.out.println("stub in refreshAddress:" + toString());
        }

        public String toString() {
            return "(Person:" 
                + this.name + "/" 
                + this.age + "/" 
                + this.gender + "/" 
                + this.address + "/" 
                + this.server + ")";
        }
    }
}
