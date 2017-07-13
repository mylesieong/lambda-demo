import java.util.List;
import java.util.ArrayList;

public class DemoLambda{

    static List<Person> roster;

    static {
        roster = new ArrayList<Person>();
        roster.add(new Person("Alex", 18));
        roster.add(new Person("Ben", 19));
        roster.add(new Person("Cathy", 20));
        roster.add(new Person("Doris", 21));
        roster.add(new Person("Elaine", 20));
        roster.add(new Person("Frank", 19));
        roster.add(new Person("Gary", 18));
        roster.add(new Person("Henry", 32));
        roster.add(new Person("Iris", 15));
        roster.add(new Person("Jerry", 12));
        roster.add(new Person("Ken", 48));
    }

    public static void main(String[] args){
        for (Person p: roster){
            System.out.println(p);
        }
    }

    public static class Person {

        String name;
        int age;

        public Person (String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
           return this.name;
        } 

        public int getAge() {
            return this.age;
        }
    
        public String toString() {
            return "(Person:" 
                + this.name + "/" 
                + this.age + ")";
        }
    }
}
