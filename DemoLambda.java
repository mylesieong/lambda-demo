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
        printPersonOlderThan(roster, 15);
        printPersonOlderThan(roster, 18);
        printPersonYoungerThan(roster,15);
        printPersonYoungerThan(roster,18);
        printPersonWithinAgeRange(roster, 15, 18);
        printPersonAdultMale(roster);
        printPersonFemale(roster);
        refreshAgeByServer(roster, Person.SERVER_LONDON);
        refreshAddressByServer(roster, Person.SERVER_CAIRO);
    }

    public static void printPersonOlderThan(List<Person> r, int a){
        for (Person p: r){
            if (p.getAge() >= a){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    public static void printPersonYoungerThan(List<Person> r, int a){
        for (Person p: r){
            if (p.getAge() < a){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    public static void printPersonWithinAgeRange(List<Person> r, int floor, int ceiling){
        for (Person p: r){
            if (p.getAge() < ceiling && p.getAge() >= floor){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    public static void printPersonAdultMale(List<Person> r){
        for (Person p: r){
            if (p.getAge() >= 18 && p.getGender() == Person.PERSON_MALE){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    public static void printPersonFemale(List<Person> r){
        for (Person p: r){
            if (p.getGender() == Person.PERSON_FEMALE){
                System.out.println(p);
            }
        }
        System.out.println();
    }
    
    public static void refreshAgeByServer(List<Person> r, int s){
        for (Person p: r){
            if (p.getServer() == s){
                p.refreshAge();
            }
        }
        System.out.println();
    }

    public static void refreshAddressByServer(List<Person> r, int s){
        for (Person p: r){
            if (p.getServer() == s){
                p.refreshAddress();
            }
        }
        System.out.println();
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
