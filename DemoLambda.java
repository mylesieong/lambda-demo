import java.util.List;
import java.util.ArrayList;

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
        printPersons(roster, new CheckPersonOlderThan15());
        printPersons(roster, new CheckPersonOlderThan18());
        printPersons(roster, new CheckPersonYoungerThan15());
        printPersons(roster, new CheckPersonYoungerThan18());
        printPersons(roster, new CheckPersonWithinRange15To18());
        printPersons(roster, new CheckPersonAdultMale());
        printPersons(roster, new CheckPersonFemale());
        refreshAges(roster, new CheckPersonServerLondon());
        refreshAddresses(roster, new CheckPersonServerCairo());
    }

    public static void printPersons(List<Person> r, CheckPerson c){
        for (Person p: r){
            if (c.test(p)){
                System.out.println(p);
            }
        }
        System.out.println();
    }
    
    public static void refreshAges(List<Person> r, CheckPerson c){
        for (Person p: r){
            if (c.test(p)){
                p.refreshAge();
            }
        }
        System.out.println();
    }

    public static void refreshAddresses(List<Person> r, CheckPerson c){
        for (Person p: r){
            if (c.test(p)){
                p.refreshAddress();
            }
        }
        System.out.println();
    }

    public interface CheckPerson{
        public boolean test(Person p);
    }

    public static class CheckPersonOlderThan15 implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getAge() >= 15; 
        } 
    }

    public static class CheckPersonOlderThan18 implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getAge() >= 18; 
        } 
    }

    public static class CheckPersonYoungerThan15 implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getAge() < 15; 
        } 
    }

    public static class CheckPersonYoungerThan18 implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getAge() < 18; 
        } 
    }

    public static class CheckPersonWithinRange15To18 implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getAge() >= 15 && p.getAge() < 18; 
        } 
    }

    public static class CheckPersonAdultMale implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getAge() >= 18 && p.getGender() == Person.PERSON_MALE ; 
        } 
    }

    public static class CheckPersonFemale implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getGender() == Person.PERSON_FEMALE ; 
        } 
    }

    public static class CheckPersonServerLondon implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getServer() == Person.SERVER_LONDON; 
        } 
    }

    public static class CheckPersonServerCairo implements CheckPerson {
        @Override
        public boolean test(Person p){ 
            return p.getServer() == Person.SERVER_CAIRO; 
        } 
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
