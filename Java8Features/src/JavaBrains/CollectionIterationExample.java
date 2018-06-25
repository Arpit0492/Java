package JavaBrains;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ARPIT JOHRI on 01-12-2016.
 */
public class CollectionIterationExample {
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

//        System.out.printf("Using for loop");
//        for (int i = 0; i <people.size(); i++) {
//            System.out.println(people.get(i));
//        }
//                                                            // EXTERNAL ITERATORS
//        System.out.printf("Using older for each");
//        for (JavaBrains.Person p :people) {
//            System.out.println(p);
//        }


        // Advantage
        // Makes it easier for processor to run in multiple threads             //Internal Iterators
        System.out.printf("Using lambda for each loop\n");
       // people.forEach(p-> System.out.println(p));
        people.forEach(System.out::println);


    }
}
