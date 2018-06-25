package JavaBrains; /**
 * Created by ARPIT JOHRI on 28-11-2016.
 */

/**************JAVA 7 WAY*********************/

import java.util.*;
public class Unit1Excercise {


    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles","Dickens",60),
                new Person("Ghosh","kens",46),
                new Person("Ben","Wright",26),
                new Person("Van","Blake",33),
                new Person("Makbli","vinod",51),
                new Person("matt","prior",29),
                new Person("Dick","John",25)
        );


        //Step 1: Sort list by last name

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        //Step 2: Create a method that prints all the elements in the list
        printAll(people);


        //STEP 3: Create a method that prints all people that have first name beginning with V

        /*
        Instead of explicitly checking the beginning of first Name
        we can pass the behaviour to the function like this
         */

        printFirstBeginsWith(people,new Condition(){

            @Override
            public boolean test(Person p) {
                return p.getFirstName().charAt(0)=='V';
            }
        });
    }

    private static void printAll(List<Person> people) {
        for (Person p :people) {
            System.out.println(p);
        }
    }

    private static void printFirstBeginsWith(List<Person> people,Condition condition) {
        for (Person p :people) {
            if (condition.test(p))
                System.out.println(p);
        }
    }


}



interface Condition{
    boolean test(Person p);
}
