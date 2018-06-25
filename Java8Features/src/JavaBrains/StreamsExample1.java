package JavaBrains;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by ARPIT JOHRI on 01-12-2016.
 */
public class StreamsExample1 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles","Jickens",60),
                new Person("Ghosh","kens",46),
                new Person("Ben","Wright",26),
                new Person("Van","Blake",33),
                new Person("Makbli","vinod",51),
                new Person("matt","prior",29),
                new Person("Dick","John",25)
        );

        //Create an assembly line
        /*
        On a stream you can have multiple operations performed on each object, and each operation
        has chance to modify the stream or to change what happens next in that stream.
         */
//        people.stream()
//                .filter(p->p.getLastName().startsWith("J"))
//                .forEach(p-> System.out.println(p.getFirstName()));


//        long count = people.parallelStream()
//                .filter(p->p.getFirstName().startsWith("V"))
//                .count();

        Person [] p = people.toArray(new Person[people.size()]);
        Stream<Person> stream = Stream.of(p);
        stream.forEach(person -> System.out.println(person.getAge()));

//        System.out.println(count);
    }
}
