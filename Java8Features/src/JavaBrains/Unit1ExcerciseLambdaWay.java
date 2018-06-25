package JavaBrains; /**
 * Created by ARPIT JOHRI on 29-11-2016.
 */


/**************JAVA 8 WAY*********************/

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Unit1ExcerciseLambdaWay {


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

        Collections.sort(people, (Person p1, Person p2)->p1.getLastName().compareToIgnoreCase(p2.getLastName()));

        //Step 2: Create a method that prints all the elements in the list
       // printAll(people);

        printFirstBeginsWith(people,p->true,p-> System.out.println(p));
        //STEP 3: Create a method that prints all people that have first name beginning with V
        System.out.println("-------------");
        /*
        Instead of explicitly checking the beginning of first Name
        we can pass the behaviour to the function like this
         */

        printFirstBeginsWith(people,(Person p)->p.getFirstName().startsWith("V"),p-> System.out.println(p));
    }

    private static void printFirstBeginsWith(List<Person> people, Predicate<Person> condition, Consumer<Person> consumer) {
        for (Person p :people) {
            if (condition.test(p))
                consumer.accept(p);
        }
    }


}
