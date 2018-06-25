package JavaBrains;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by ARPIT JOHRI on 01-12-2016.
 */
public class MethodReferenceExample2 {
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

//        printFirstBeginsWith(people,p->true,p-> System.out.println(p));// this is also a pass through
        printFirstBeginsWith(people,p->true,System.out::println); // p->method(p) and without any parameter ()->method()

    }

    private static void printFirstBeginsWith(List<Person> people, Predicate<Person> condition, Consumer<Person> consumer) {
        for (Person p :people) {
            if (condition.test(p))
                consumer.accept(p);
        }
    }
}
